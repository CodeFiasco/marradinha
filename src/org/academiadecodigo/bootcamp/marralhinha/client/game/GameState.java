package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.client.Client;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Text;
import org.academiadecodigo.bootcamp.marralhinha.utils.Messages;
import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

import java.util.List;

public class GameState {

    private Text text;
    private Client client;
    private List<Player> players;
    private boolean myTurn;
    private boolean canRoll;
    private int diceValue;
    private int id;

    public GameState(Text text) {
        this.text = text;
    }

    public void roll() {
        diceValue = Utils.getRandomInt();
    }

    public int getDiceValue() {
        return diceValue;
    }

    public void movePlayer(int id, int col, int row, int times) {
        players.get(id).move(col, row, times);
    }

    public void sendMoveMessage(int col, int row, int times) {
        client.sendMessage(Messages.MOVE + " " + id + " " + col + " " + row + " " + times);
    }

    public boolean isActivePlayer(Player player) {
        return players.get(id) == player;
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;

        String text = myTurn ? "Rolled: " + diceValue : "Waiting";
        this.text.setText(text);
    }

    public boolean isMyTurn() {
        return myTurn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean canRoll() {
        return canRoll;
    }

    public void setCanRoll(boolean canRoll) {
        this.canRoll = canRoll;

        if (canRoll) {
            text.setText("Roll dice");
        }
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void skip() {
        client.sendMessage(Messages.SKIP);
        myTurn = false;
        text.setText("Waiting");
    }
}
