package org.academiadecodigo.bootcamp.marralhinha.server;

import org.academiadecodigo.bootcamp.marralhinha.utils.Utils;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {

        try {
            new Server().init();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
