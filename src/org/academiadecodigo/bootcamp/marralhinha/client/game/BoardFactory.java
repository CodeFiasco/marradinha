package org.academiadecodigo.bootcamp.marralhinha.client.game;

import org.academiadecodigo.bootcamp.marralhinha.client.game.spot.Entry;
import org.academiadecodigo.bootcamp.marralhinha.client.game.spot.Queue;
import org.academiadecodigo.bootcamp.marralhinha.client.game.spot.Spot;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;

import java.util.ArrayList;
import java.util.List;

public class BoardFactory {

    public static void generate(GraphicsFactory graphics, List<Player> players) {
        if (players.size() != 4) {
            return;
        }

        Spot start = new Spot(graphics, 12, 17);

        Spot aux = start;
        generateQueue(graphics, players.get(0), aux, 8, 18, 1, 0);

        aux = generateLine(graphics, aux, 6, 12, 17, 0, -1);
        aux = generateLine(graphics, aux, 6, 12, 11, 1, 0);
        aux = generateLine(graphics, aux, 4, 18, 11, 0, -1);

        generateQueue(graphics, players.get(1), aux, 19, 11, 0, -1);

        aux = generateLine(graphics, aux, 6, 18, 7, -1, 0);
        aux = generateLine(graphics, aux, 6, 12, 7, 0, -1);
        aux = generateLine(graphics, aux, 4, 12, 1, -1, 0);

        generateQueue(graphics, players.get(2), aux, 8, 0, 1, 0);

        aux = generateLine(graphics, aux, 6, 8, 1, 0, 1);
        aux = generateLine(graphics, aux, 6, 8, 7, -1, 0);
        aux = generateLine(graphics, aux, 4, 2, 7, 0, 1);

        generateQueue(graphics, players.get(3), aux, 1, 7,0,1);

        aux = generateLine(graphics, aux, 6, 2, 11, 1, 0);
        aux = generateLine(graphics, aux, 6, 8, 11, 0, 1);
        aux = generateLine(graphics, aux, 1, 8, 17, 1, 0);

        Entry red = new Entry(graphics, 10, 17);
        aux.setNext(red);

        aux = new Spot(graphics, 10, 16);
        red.setPath(aux);
        red.setKey(players.get(0));

        generateLine(graphics, aux, 4, 10, 16, 0, -1);

        aux = generateLine(graphics, red, 1, 10, 17, 1, 0);

        red.setNext(aux);
        aux.setNext(start);
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

    private static void generateQueue(GraphicsFactory graphics, Player player, Spot exit, int col, int row, int colDelta, int rowDelta) {
        List<Spot> playerQueue = new ArrayList<>(5);
        player.setQueue(playerQueue);

        for (int i = 0; i < 5; i++) {
            Queue queue = new Queue(graphics, col + i * colDelta, row + i * rowDelta);
            queue.changeResident(player);
            queue.setNext(exit);
            playerQueue.add(queue);
        }
    }
}
