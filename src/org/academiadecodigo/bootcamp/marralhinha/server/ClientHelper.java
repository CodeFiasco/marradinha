package org.academiadecodigo.bootcamp.marralhinha.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHelper implements Runnable {

    private Server server;
    private PrintWriter out;
    private BufferedReader in;
    private Socket clientSocket;


    public ClientHelper(Socket clientSocket) {

        try {

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (clientSocket.isBound()) {

            System.out.println("msg: ");

            String message = null;

            try {
                message = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            out.println(message);
        }

    }
}
