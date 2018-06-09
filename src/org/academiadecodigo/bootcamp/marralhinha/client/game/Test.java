package org.academiadecodigo.bootcamp.marralhinha.client.game;


import org.academiadecodigo.bootcamp.marralhinha.client.game.spot.Spot;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing.SwingFactory;

import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        GraphicsFactory graphicsFactory = new SwingFactory(21, 21);
        GameState state = new GameState();
        List<Player> players = new LinkedList<>();
        players.add(new Player(state, Color.RED));
        players.add(new Player(state, Color.BLUE));
        players.add(new Player(state, Color.GREEN));
        players.add(new Player(state, Color.YELLOW));

        BoardFactory.generate(graphicsFactory, players);
    }

}
