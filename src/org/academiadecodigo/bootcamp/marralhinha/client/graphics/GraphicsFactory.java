package org.academiadecodigo.bootcamp.marralhinha.client.graphics;

public interface GraphicsFactory {
    Button getButton(ClickHandler handler, int col, int row);
    Button getButton(ClickHandler handler, String text, int col, int row, int width);
}
