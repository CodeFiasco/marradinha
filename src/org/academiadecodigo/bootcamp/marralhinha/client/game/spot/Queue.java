package org.academiadecodigo.bootcamp.marralhinha.client.game.spot;

import org.academiadecodigo.bootcamp.marralhinha.client.game.Player;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;

public class Queue extends Spot{

    private static final int LEAVE_VALUE = 6;

    public Queue(GraphicsFactory factory, int col, int row) {
        super(factory, col, row);
    }

    @Override
    public Spot move(Player mover, int times) {
        if (times != LEAVE_VALUE) {
            return this;
        }

        return super.move(mover, 1);
    }
}
