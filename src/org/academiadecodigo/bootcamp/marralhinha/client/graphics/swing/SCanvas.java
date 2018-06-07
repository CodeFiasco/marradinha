package org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing;

import javax.swing.*;
import java.awt.*;

public class SCanvas {

    private static final String TITLE = "Marralhinha";
    private static final int PADDING = 10;
    private static final int CELL_SIZE = 30;

    private JFrame frame;

    public SCanvas(int cols, int rows) {
        frame = new JFrame(TITLE);
        frame.setSize(
                cols * CELL_SIZE + PADDING,
                rows * CELL_SIZE + PADDING
        );
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void add(Component component) {
        frame.add(component);
    }

    public void refresh() {
        frame.repaint();
    }

    public int colToX(int col) {
        return col * CELL_SIZE + PADDING;
    }

    public int rowToY(int row) {
        return row * CELL_SIZE + PADDING;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }
}
