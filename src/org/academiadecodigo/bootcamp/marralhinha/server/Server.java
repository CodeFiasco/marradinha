package org.academiadecodigo.bootcamp.marralhinha.server;

import org.academiadecodigo.bootcamp.marralhinha.utils.Connection;
import org.academiadecodigo.bootcamp.marralhinha.utils.Messages;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final static int PLAYERS = 4;

    private ServerSocket serverSocket;
    private GameServer game;

    public Server(int port) throws IOException{
        serverSocket = new ServerSocket(port);
    }

    public void init() {

        System.out.println("Server is now connected and waiting for requests at port " + serverSocket.getLocalPort());
        waitingForClients();
        game.start();
    }

    private void waitingForClients() {
        game = new GameServer(PLAYERS);
        int connectedClients = 0;

        while (connectedClients < PLAYERS) {

            try {
                Socket clientSocket = serverSocket.accept();
                Connection connection = new Connection(clientSocket, game);

                System.out.println("Waiting for more clients at port " + serverSocket.getLocalPort());
                game.addClient(connection);

                new Thread(connection).start();

                connection.sendMessage(Messages.ID + " " + connectedClients);
                connectedClients++;

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
