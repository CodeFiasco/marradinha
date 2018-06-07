package org.academiadecodigo.bootcamp.marralhinha.server;

import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameServer {

    private List<ClientHelper> clients;
    private BlockingQueue<String> events;

    public GameServer() {
        clients = new ArrayList<>(Server.PLAYERS);
        events = new LinkedBlockingQueue<>();
    }

    public void addClient(ClientHelper client) {
        clients.add(client);
    }

    public void addEvent(String message) {
        events.add(message);
    }

    public void start() {
        try {
            ClientHelper first = initialDiceRoll(clients);
            play(first);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ClientHelper initialDiceRoll(List<ClientHelper> clients) throws InterruptedException {
        List<ClientHelper> aux = new LinkedList<>();
        int[] rolls = new int[clients.size()];

        askForRolls(clients, rolls);
        selectBiggest(aux, rolls);

        if (aux.size() > 1) {
            return initialDiceRoll(aux);
        }

        return aux.get(0);
    }

    private void askForRolls(List<ClientHelper> clients, int[] rolls) throws InterruptedException {
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).sendMessage("R: ");
            rolls[i] = Utils.StringToInt(events.take());
        }
    }

    private void selectBiggest(List<ClientHelper> clients, int[] rolls) {
        for (int i = 0, biggest = 0; i < rolls.length; i++) {
            if (rolls[i] > biggest) {

                biggest = rolls[i];
                clients.clear();
            }

            if (rolls[i] == biggest) {
                clients.add(clients.get(i));
            }
        }
    }

    private void play(ClientHelper first) throws InterruptedException {

        //Pedir ao jogador para jogar
        //Receber resultado
        //


    }
}
