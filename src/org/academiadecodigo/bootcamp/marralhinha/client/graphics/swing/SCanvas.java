package org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing;

import javax.swing.*;

public class SCanvas {

    public static final int PADDING = 10;
    private static final String TITLE = "Marralhinha";

    private JFrame frame;

    public SCanvas() {
        frame = new JFrame(TITLE);
        frame.setSize(21 * SBoard.CELL_SIZE + PADDING, 22 * SBoard.CELL_SIZE + PADDING);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void add(Component component) {
        frame.add(component.getComponent());
    }

    public void refresh() {
        frame.repaint();
    }

}
