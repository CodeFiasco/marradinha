package org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing;

import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Text;

import javax.swing.*;

public class SText implements Text {

    private SCanvas canvas;
    private JLabel label;

    public SText(SCanvas canvas, String text, int col, int row) {
        this.canvas = canvas;

        label = new JLabel(text);
        label.setBounds(
                canvas.colToX(col),
                canvas.rowToY(row),
                canvas.getCellSize() * 3,
                canvas.getCellSize() * 3
        );

        canvas.add(label);
        canvas.refresh();
    }

    public void setText(String text) {
        label.setText(text);
        canvas.refresh();
    }
}
