package org.academiadecodigo.bootcamp.marralhinha.client;

import org.academiadecodigo.bootcamp.marralhinha.client.game.BoardFactory;
import org.academiadecodigo.bootcamp.marralhinha.client.game.GameState;
import org.academiadecodigo.bootcamp.marralhinha.client.game.Player;
import org.academiadecodigo.bootcamp.marralhinha.client.game.RollButton;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;
import org.academiadecodigo.bootcamp.marralhinha.utils.Connection;
import org.academiadecodigo.bootcamp.marralhinha.utils.EventHandler;
import org.academiadecodigo.bootcamp.marralhinha.utils.Messages;
import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Client implements EventHandler {

    private Connection connection;
    private BlockingQueue<String> events;
    private GameState game;

    public Client(String host, int port, GameState gameState) throws IOException {
        connection = new Connection(new Socket(host, port), this);
        events = new LinkedBlockingQueue<>();
        this.game = gameState;
    }

    public void init(GraphicsFactory factory) {
        List<Player> players = new LinkedList<>();
        players.add(new Player(game, Color.RED));
        players.add(new Player(game, Color.BLUE));
        players.add(new Player(game, Color.GREEN));
        players.add(new Player(game, Color.YELLOW));

        BoardFactory.generate(factory, players);
        game.setPlayers(players);
        game.setClient(this);
        new RollButton(game, factory);

    }

    public void start() throws InterruptedException {
        new Thread(connection).start();


        while (true) {

            String event = events.take();

            parseString(event);

        }
    }

    private void parseString(String event) {
        String[] arguments = event.split(" ");

        switch (arguments[0]) {

            case Messages.PLAY:
                System.out.println("Your turn");
                game.setCanRoll(true);
                break;

            case Messages.MOVE:
                move(arguments[1], arguments[2], arguments[3], arguments[4]);
                break;

            case Messages.ID:
                game.setId(Utils.StringToInt(arguments[1]));
                break;

            case Messages.QUESTION:
                int rand = Utils.getRandomInt();
                sendMessage(Integer.toString(rand));

        }

    }

    private void move(String id, String col, String row, String times) {
        game.movePlayer(
                Utils.StringToInt(id),
                Utils.StringToInt(col),
                Utils.StringToInt(row),
                Utils.StringToInt(times)
        );
    }

    @Override
    public void addEvent(String message) {
        events.add(message);
    }

    public void sendMessage(String message) {
        connection.sendMessage(message);
    }
}
