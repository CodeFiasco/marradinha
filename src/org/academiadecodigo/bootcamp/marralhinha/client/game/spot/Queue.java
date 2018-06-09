package org.academiadecodigo.bootcamp.marralhinha.client.game.spot;

import org.academiadecodigo.bootcamp.marralhinha.client.game.Player;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;

public class Queue extends Spot{

    private static final int[] LEAVE_VALUES = {1, 6};

    public Queue(GraphicsFactory factory, int col, int row) {
        super(factory, col, row);
    }

    @Override
    public Spot getNextSpot(Player mover, int times) {
        if (!isLeaveValue(times)) {
            return null;
        }

        return super.getNextSpot(mover, 1);
    }

    private boolean isLeaveValue(int value) {
        for (int v : LEAVE_VALUES) {
            if (value == v) {
                return true;
            }
        }

        return false;
    }
}
