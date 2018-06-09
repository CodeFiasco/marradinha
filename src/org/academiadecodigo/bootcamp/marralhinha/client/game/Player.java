package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.client.game.spot.Spot;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Color color;
    private GameState game;
    private List<Spot> queue;

    public Player(GameState game, Color color) {
        this.game = game;
        this.color = color;
    }

    public void move(Spot cursor) {
        if (!game.isMyTurn()) {
            return;
        }

        int moves = game.getDiceValue();
        Spot aux = cursor.move(this, moves);

        if (aux == null) {
            // invalid move
            return;
        }

        if (aux != cursor) {
            cursor.changeResident(null);
            aux.changeResident(this);
        }
    }

    public void reset() {
        for (Spot place : queue) {

            if (!place.isOccupied()) {
                place.changeResident(this);
                break;
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public void setQueue(List<Spot> queue) {
        this.queue = queue;
    }
}
