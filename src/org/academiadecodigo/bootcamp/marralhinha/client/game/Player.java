package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.client.game.spot.Spot;
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
        Spot aux = cursor.move(this, moves);

        if (aux != cursor) {
            cursor.changeResident(null);
            aux.changeResident(this);
        }
    }

    public Color getColor() {
        return color;
    }
}
