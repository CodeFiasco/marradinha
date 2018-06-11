package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.client.graphics.ClickHandler;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;

public class RollButton implements ClickHandler {

    private GameState game;

    public RollButton(GameState game, GraphicsFactory factory) {
        this.game = game;
        factory.getButton(this, "ROLL", 3, 17, 3);
    }

    @Override
    public void clicked() {
        if (!game.canRoll()) {
            return;
        }

        game.roll();
    }
}
