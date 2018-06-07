package org.academiadecodigo.bootcamp.marralhinha.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHelper implements Runnable {

    private GameServer server;
    private PrintWriter out;
    private BufferedReader in;
    private Socket clientSocket;
    private int id;


    public ClientHelper(int id, Socket clientSocket, GameServer server) throws IOException {
        this.id = id;
        this.server = server;
        this.clientSocket = clientSocket;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @Override
    public void run() {

        while (clientSocket.isBound()) {

            try {
                String message = in.readLine();
                server.addEvent(id + " " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}