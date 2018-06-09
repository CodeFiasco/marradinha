package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

public class GameState {

    private boolean myTurn;
    private int diceValue;

    public GameState() {
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
