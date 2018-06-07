package org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing;

import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Button;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.ClickHandler;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;

import javax.swing.*;

public class SButton implements Button {

    private static final int PADDING = 6;

    private SCanvas canvas;
    private int col;
    private int row;
    private ClickHandler handler;
    private JButton button;

    public SButton(SCanvas canvas, ClickHandler handler, int col, int row) {
        this.canvas = canvas;
        this.handler = handler;
        this.col = col;
        this.row = row;

        button = new JButton();
        button.setBounds(
                canvas.colToX(col) - PADDING / 2,
                canvas.rowToY(row) - PADDING / 2,
                canvas.getCellSize() - PADDING,
                canvas.getCellSize() - PADDING
        );

        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(ColorMapper.get(Color.WHITE));
        button.addActionListener(e -> click());

        canvas.add(button);
    }

    private void click() {
        handler.clicked(col, row);
    }

    public void fill(Color color) {
        button.setBackground(ColorMapper.get(color));
        canvas.refresh();
    }
}
