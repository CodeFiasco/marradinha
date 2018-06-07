package org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing;

import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Button;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.ClickHandler;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;

public class SwingFactory implements GraphicsFactory {

    private SCanvas canvas;

    public SwingFactory(int cols, int rows) {
        canvas = new SCanvas(cols, rows);
    }

    @Override
    public Button getButton(ClickHandler handler, int col, int row) {
        return new SButton(canvas, handler, "", col, row, 1);
    }
}
