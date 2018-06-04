package org.academiadecodigo.bootcamp.marralhinha.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private final static int PORT_NUMBER = 9000;
    private List<ClientHelper> clientList = new ArrayList<>(4);
    private ClientHelper clientHelper;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private void start() {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9090);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {


            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();

                System.out.println("Server is now connected and waiting for requests at port " + PORT_NUMBER);
                ClientHelper clientHelper = new ClientHelper(clientSocket);
                clientList.add(clientHelper);

            } catch (IOException e) {
                System.err.println("Missing port number");
            }

        }

    }


}
