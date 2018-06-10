package org.academiadecodigo.bootcamp.marralhinha.server;

import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

import java.io.IOException;

public class ServerLauncher {

    private final static int DEFAULT_PORT = 9000;

    public static void main(String[] args) {

        int port =  DEFAULT_PORT;

        try {
            if (args.length == 1) {
                port = Utils.StringToInt(args[0]);
            }

            new Server(port).init();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (NumberFormatException e) {
            System.err.println("Error: port must be a valid number");
        }
    }

}
