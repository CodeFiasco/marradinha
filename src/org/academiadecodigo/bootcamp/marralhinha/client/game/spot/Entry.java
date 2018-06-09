package org.academiadecodigo.bootcamp.marralhinha.client.game.spot;

import org.academiadecodigo.bootcamp.marralhinha.client.game.Player;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;

public class Entry extends Spot {

    private Spot path;
    private Player key;

    public Entry(GraphicsFactory factory, int col, int row) {
        super(factory, col, row);
    }

    @Override
    public Spot getNextSpot(Player mover, int times) {

        if (times == 0 || mover != key) {
            return super.getNextSpot(mover, times);
        }

        return path.getNextSpot(mover, times - 1);
    }

    public void setPath(Spot path) {
        this.path = path;
    }

    public void setKey(Player key) {
        this.key = key;
    }
}
