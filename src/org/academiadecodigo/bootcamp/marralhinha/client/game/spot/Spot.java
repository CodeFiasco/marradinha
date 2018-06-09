package org.academiadecodigo.bootcamp.marralhinha.client.game.spot;

import org.academiadecodigo.bootcamp.marralhinha.client.game.Player;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Button;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.ClickHandler;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;

public class Spot implements ClickHandler {

    private Button button;
    private Player resident;
    private Spot next;

    public Spot(GraphicsFactory factory, int col, int row) {
        this.button = factory.getButton(this, col, row);
    }

    @Override
    public void clicked() {
        if (resident == null) {
            return;
        }

        resident.move(this);
    }

    public Spot move(Player mover, int times) {
        if (times == 0) {
            return this;
        }

        if (next == null || next.resident == mover) {
            return null;
        }

        return next.move(mover, times - 1);
    }

    public void changeResident(Player resident) {
        if (this.resident != null && resident != null) {
            this.resident.reset();
        }

        Color color = resident == null ? Color.WHITE : resident.getColor();
        button.fill(color);

        this.resident = resident;
    }

    public boolean isOccupied() {
        return resident != null;
    }

    public void setNext(Spot next) {
        this.next = next;
    }

}
