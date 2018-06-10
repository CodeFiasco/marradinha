package org.academiadecodigo.bootcamp.marralhinha.client;

import org.academiadecodigo.bootcamp.marralhinha.client.game.GameState;
import org.academiadecodigo.bootcamp.marralhinha.client.game.Player;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing.SwingFactory;
import org.academiadecodigo.bootcamp.marralhinha.server.Server;
import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Launcher {

    private static final String DEFAULT_HOST = "127.0.0.1";

    public static void main(String[] args) {
        String host = DEFAULT_HOST;
        int port = Server.DEFAULT_PORT;

        if (args.length == 2) {
            host = args[0];
            port = Utils.StringToInt(args[1]);
        }

        try {
            Client client = new Client(host, port);
            client.init(new SwingFactory(21, 21));
            client.start();

        } catch (IOException e) {
            System.err.println("Unable to connect: " + e.getMessage());

        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
