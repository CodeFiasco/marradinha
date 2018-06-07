package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;

public class Player {

    private Color color;
    private GameState game;

    public Player(GameState game, Color color) {
        this.game = game;
        this.color = color;
    }

    public void move(Spot cursor) {
        if (!game.isMyTurn()) {
            return;
        }

        int moves = game.getDiceValue();
        Spot iterator = cursor;

        while (moves > 0) {
            iterator = iterator.getNext();
            moves--;

            if (iterator.getResident() == this) {
                return;
            }
        }

        cursor.changeResident(null);
        iterator.changeResident(this);
    }

    public void reset(Spot cursor) {
        // return cursor to queue
    }

    public Color getColor() {
        return color;
    }
}
