package org.academiadecodigo.bootcamp.marralhinha.client.game;

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

    public void changeResident(Player resident) {
        if (resident == null) {
            button.fill(Color.WHITE);
            this.resident = null;
            return;
        }

        if (this.resident != null) {
            this.resident.reset(this);
        }

        this.resident = resident;
        button.fill(resident.getColor());
    }

    public Player getResident() {
        return resident;
    }

    public void setNext(Spot next) {
        this.next = next;
    }

    public Spot getNext() {
        return next;
    }
}
