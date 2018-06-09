package org.academiadecodigo.bootcamp.marralhinha.client;

import org.academiadecodigo.bootcamp.marralhinha.utils.Connection;
import org.academiadecodigo.bootcamp.marralhinha.utils.EventHandler;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Client implements EventHandler {

    //recebe pedido para jogar
    //rola os dados
    //
    //devolve resultado ao game
    //
    private Connection connection;
    private BlockingQueue<String> events;

    public Client(String host, int port) throws IOException {
        connection = new Connection(new Socket(host, port), this);
        events = new LinkedBlockingQueue<>();
    }

    public void start() throws InterruptedException {
        new Thread(connection).start();

        while (true) {
            String event = events.take();

            connection.sendMessage("batatas");
        }
    }

    @Override
    public void addEvent(String message) {
        events.add(message);
    }

    public void sendMessage(String message) {
        connection.sendMessage(message);
    }
}
