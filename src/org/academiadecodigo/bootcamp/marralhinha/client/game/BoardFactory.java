package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.client.game.spot.Entry;
import org.academiadecodigo.bootcamp.marralhinha.client.game.spot.Spot;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;

import java.util.ArrayList;
import java.util.List;

public class BoardFactory {

    public static List<Spot> generate(GraphicsFactory graphics, List<Player> players) {
        List<Spot> beginnings = new ArrayList<>(4);

        Spot start = new Spot(graphics, 12, 17);

        Spot aux = start;
        beginnings.add(aux);

        aux = generateLine(graphics, aux, 6, 12, 17, 0, -1);
        aux = generateLine(graphics, aux, 6, 12, 11, 1, 0);
        aux = generateLine(graphics, aux, 4, 18, 11, 0, -1);

        beginnings.add(aux);

        aux = generateLine(graphics, aux, 6, 18, 7, -1, 0);
        aux = generateLine(graphics, aux, 6, 12, 7, 0, -1);
        aux = generateLine(graphics, aux, 4, 12, 1, -1, 0);

        beginnings.add(aux);
        aux.changeResident(players.get(1));

        aux = generateLine(graphics, aux, 6, 8, 1, 0, 1);
        aux = generateLine(graphics, aux, 6, 8, 7, -1, 0);
        aux = generateLine(graphics, aux, 4, 2, 7, 0, 1);

        beginnings.add(aux);

        aux = generateLine(graphics, aux, 6, 2, 11, 1, 0);
        aux = generateLine(graphics, aux, 6, 8, 11, 0, 1);
        aux = generateLine(graphics, aux, 1, 8, 17, 1, 0);

        Entry red = new Entry(graphics, 10, 17);
        aux.setNext(red);

        aux = new Spot(graphics, 10, 16);
        red.setPath(aux);
        red.setKey(players.get(0));

        generateLine(graphics, aux,4, 10, 16, 0, -1);

        aux = generateLine(graphics, red, 1, 10, 17, 1, 0);

        red.setNext(aux);
        aux.setNext(start);

        return beginnings;
    }

    private static Spot generateLine(GraphicsFactory graphics, Spot start, int count, int col, int row, int colDelta, int rowDelta) {

        for (; count > 0; count--) {
            col += colDelta;
            row += rowDelta;

            Spot aux = new Spot(graphics, col, row);
            start.setNext(aux);
            start = aux;
        }

        return start;
    }
}
