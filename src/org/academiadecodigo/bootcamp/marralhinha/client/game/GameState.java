package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

public class GameState {

    private boolean myTurn;
    private int diceValue = 3;

    public GameState() {
        myTurn = true;
    }

    public void roll() {
        diceValue = Utils.getRandomInt();
    }

    public int getDiceValue() {
        return diceValue;
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }

    public boolean isMyTurn() {
        return myTurn;
    }
}
