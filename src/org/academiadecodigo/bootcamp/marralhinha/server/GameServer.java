package org.academiadecodigo.bootcamp.marralhinha.server;

import org.academiadecodigo.bootcamp.marralhinha.utils.Connection;
import org.academiadecodigo.bootcamp.marralhinha.utils.EventHandler;
import org.academiadecodigo.bootcamp.marralhinha.utils.Messages;
import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameServer implements EventHandler {

    private List<Connection> clients;
    private BlockingQueue<String> events;
    private boolean gameOver = false;

    public GameServer(int numberOfClients) {
        clients = new ArrayList<>(numberOfClients);
        events = new LinkedBlockingQueue<>();
    }

    public void addClient(Connection client) {
        clients.add(client);
    }

    public void addEvent(String message) {
        events.add(message);
    }

    public void start() {
        try {
            Connection first = initialDiceRoll(clients);
            System.out.println("start");
            play(first);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Connection initialDiceRoll(List<Connection> clients) throws InterruptedException {
        int[] rolls = new int[clients.size()];

        askForRolls(clients, rolls);
        List<Connection> aux = selectBiggest(clients, rolls);

        if (aux.size() > 1) {
            return initialDiceRoll(aux);
        }

        return aux.get(0);
    }

    private void askForRolls(List<Connection> clients, int[] rolls) throws InterruptedException {
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).sendMessage(Messages.QUESTION);
            rolls[i] = Utils.StringToInt(events.take());
            System.out.println(i + " rolled " + rolls[i]);
        }
    }

    private List<Connection> selectBiggest(List<Connection> clients, int[] rolls) {
        List<Connection> result = new LinkedList<>();

        for (int i = 0, biggest = 0; i < rolls.length; i++) {
            if (rolls[i] > biggest) {

                biggest = rolls[i];
                result.clear();
            }

            if (rolls[i] == biggest) {
                result.add(clients.get(i));
            }
        }

        return result;
    }

    private void play(Connection player) throws InterruptedException {
        int currentPlayer = clients.indexOf(player);
        currentPlayer -= 1;

        while (!gameOver) {

            currentPlayer = currentPlayer == clients.size() - 1 ? 0 : currentPlayer + 1;

            clients.get(currentPlayer).sendMessage(Messages.PLAY);
            String currentPlay = events.take();

            String[] arguments = currentPlay.split(" ");

            if (arguments[4].equals("6")){
                currentPlayer--;
            }

            if (currentPlay.equals(Messages.SKIP)) {
                continue;
            }

            broadcast(currentPlay);

            checkIfPlayerWon(currentPlay);

        }

    }

    private void broadcast(String message) {
        for (Connection client : clients) {
            client.sendMessage(message);
        }
    }

    private void checkIfPlayerWon(String message) {
        if (message.equals(Messages.WIN)) {
            gameOver = true;
        }
    }

}
