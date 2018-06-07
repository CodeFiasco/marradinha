package org.academiadecodigo.bootcamp.marralhinha.client.game;


import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing.SwingFactory;

public class Test {

    public static void main(String[] args) {
        GraphicsFactory factory = new SwingFactory(20, 20);
        Player p = new Player(new GameState(null), Color.RED);

        Spot iterator = new Spot(factory, 0, 1);
        iterator.changeResident(p);

        Spot begin = iterator;

        for (int i = 1; i < 20; i++) {
            Spot aux = new Spot(factory, i, 1);
            iterator.setNext(aux);
            iterator = aux;
        }

        iterator.setNext(begin);

    }

}
