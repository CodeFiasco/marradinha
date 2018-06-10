package org.academiadecodigo.bootcamp.marralhinha.client;

import org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing.SwingFactory;
import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Usage: Marralhina <server_ip> <server_port>");
            return;
        }

        try {
            Client client = new Client(args[0], Utils.StringToInt(args[1]));
            client.init(new SwingFactory(21, 21));
            client.start();

        } catch (IOException e) {
            System.err.println("Unable to connect: " + e.getMessage());

        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.err.println("Error: port must be a valid number");
        }
    }

}
