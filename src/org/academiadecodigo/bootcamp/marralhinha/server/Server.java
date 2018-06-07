package org.academiadecodigo.bootcamp.marralhinha.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public final static int PLAYERS = 2;
    private final static int DEFAULT_PORT = 9000;

    private ServerSocket serverSocket;
    private GameServer game;

    public Server() throws IOException {
        this(DEFAULT_PORT);
    }

    public Server(int port) throws IOException{
        serverSocket = new ServerSocket(port);
    }

    public void init() {

        System.out.println("Server is now connected and waiting for requests at port " + serverSocket.getLocalPort());
        waitingForClients();
        game.start();
    }

    private void waitingForClients() {
        game = new GameServer();
        int connectedClients = 0;

        while (connectedClients < PLAYERS) {

            try {
                Socket clientSocket = serverSocket.accept();
                ClientHelper clientHelper = new ClientHelper(connectedClients, clientSocket, game);

                System.out.println("Waiting for more clients at port " + serverSocket.getLocalPort());
                game.addClient(clientHelper);

                new Thread(clientHelper).start();
                connectedClients++;

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
