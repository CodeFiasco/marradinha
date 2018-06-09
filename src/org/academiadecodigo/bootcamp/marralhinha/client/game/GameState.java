package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.client.Client;
import org.academiadecodigo.bootcamp.marralhinha.utils.Messages;
import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

import java.util.List;

public class GameState {

    private boolean myTurn;
    private int diceValue;
    private List<Player> players;
    private Client client;
    private int id;

    public GameState() {
        myTurn = true;
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
}
