package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

import java.util.List;

public class GameState {

    private List<Player> players;
    private boolean myTurn;
    private int diceValue;

    public GameState(List<Player> players) {
        this.players = players;
        myTurn = true;
    }

    public void roll() {
        diceValue = Utils.getRandomInt();
    }

    public int getDiceValue() {
        // TODO remove both statements below (test only)
        roll();
        System.out.println(diceValue);
        return diceValue;
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }

    public boolean isMyTurn() {
        return myTurn;
    }
}
