package org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing;

import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Button;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.ClickHandler;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.GraphicsFactory;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Text;

public class SwingFactory implements GraphicsFactory {

    private SCanvas canvas;

    public SwingFactory(int cols, int rows) {
        canvas = new SCanvas(cols, rows);
    }

    @Override
    public Button getButton(ClickHandler handler, int col, int row) {
        return getButton(handler, "", col, row, 1);
    }

    @Override
    public Button getButton(ClickHandler handler, String text, int col, int row, int width) {
        return new SButton(canvas, handler, text, col, row, width);
    }

    @Override
    public Text getText(String text, int col, int row) {
        return new SText(canvas, text, col, row);
    }
}
