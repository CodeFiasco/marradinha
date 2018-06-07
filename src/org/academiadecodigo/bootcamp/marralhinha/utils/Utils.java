package org.academiadecodigo.bootcamp.marralhinha.utils;

public class Utils {

    public static int StringToInt(String str) {

        return Integer.parseInt(str);
    }

    public static int getRandomInt() {

        return (int) ((Math.random() * 6) + 1);
    }

}
