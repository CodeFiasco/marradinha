package org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing;

import org.academiadecodigo.bootcamp.marralhinha.client.graphics.ClickEvent;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.ClickHandler;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;

import javax.swing.*;

public class SButton implements Component {

    private int id;
    private JButton button;
    private ClickHandler handler;

    public SButton(int id, int x, int y, ClickHandler handler) {
        this.id = id;
        this.handler = handler;

        button = new JButton();
        button.setBounds(x - 3, y - 3, SBoard.CELL_SIZE - 6, SBoard.CELL_SIZE - 6);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(ColorMapper.get(Color.WHITE));
        button.addActionListener(e -> click());
    }

    private void click() {
        if (handler != null) {
            handler.clicked(new ClickEvent(id));
        }
    }

    @Override
    public java.awt.Component getComponent() {
        return button;
    }

    public void fill(Color color) {
        button.setBackground(ColorMapper.get(color));
    }
}
