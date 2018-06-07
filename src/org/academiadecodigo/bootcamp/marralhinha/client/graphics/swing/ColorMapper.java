package org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing;

import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;

public class ColorMapper {

    public static java.awt.Color get(Color color) {

        switch (color) {
            case BLUE:
                return java.awt.Color.BLUE;

            case RED:
                return java.awt.Color.RED;

            case GREEN:
                return java.awt.Color.GREEN;

            case YELLOW:
                return java.awt.Color.YELLOW;

            default:
                return java.awt.Color.WHITE;
        }
    }

}
