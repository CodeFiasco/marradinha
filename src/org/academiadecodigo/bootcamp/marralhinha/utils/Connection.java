package org.academiadecodigo.bootcamp.marralhinha.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection implements Runnable {

    private EventHandler handler;
    private PrintWriter out;
    private BufferedReader in;
    private Socket clientSocket;

    public Connection(Socket clientSocket, EventHandler handler) throws IOException {
        this.handler = handler;
        this.clientSocket = clientSocket;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @Override
    public void run() {

        while (clientSocket.isBound()) {

            try {
                String message = in.readLine();
                handler.addEvent(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
