package org.academiadecodigo.bootcamp.marralhinha.client.game;


import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing.SwingFactory;

public class Test {

    public static void main(String[] args) {
        GraphicsFactory graphicsFactory = new SwingFactory(21, 21);

        Spot start = BoardFactory.generate(graphicsFactory).get(0);

        GameState state = new GameState(null);
        start.changeResident(new Player(state, Color.RED));
    }

}
