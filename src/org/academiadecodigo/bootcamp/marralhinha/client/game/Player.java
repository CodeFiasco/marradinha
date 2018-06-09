package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.client.game.spot.Spot;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;
import org.academiadecodigo.bootcamp.marralhinha.utils.Messages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private Color color;
    private GameState game;
    private List<Spot> queue;
    private List<Spot> cursors;

    public Player(GameState game, Color color) {
        this.game = game;
        this.color = color;
    }

    public void move(Spot cursor) {
        if (!game.isMyTurn() || !game.isActivePlayer(this)) {
            return;
        }

        int moves = game.getDiceValue();
        Spot aux = cursor.getNextSpot(this, moves);

        if (aux == null) {
            game.skip();
            return;
        }

        swapCursors(cursor, aux);

        cursor.changeResident(null);
        aux.changeResident(this);

        game.sendMoveMessage(cursor.getCol(), cursor.getRow(), moves);
    }

    public void move(int col, int row, int times) {
        Spot old = getCursorAt(col, row);
        Spot dest = old.getNextSpot(this, times);
        swapCursors(old, dest);
    }

    private void swapCursors(Spot old, Spot dest) {
        cursors.remove(old);
        cursors.add(dest);
    }

    private Spot getCursorAt(int col, int row) {
        for (Spot cursor : cursors) {
            if (cursor.isAt(col, row)) {
                return cursor;
            }
        }

        return null;
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
        cursors = new ArrayList<>(queue.size());
        Collections.copy(cursors, queue);
    }
}
