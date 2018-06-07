package org.academiadecodigo.bootcamp.marralhinha.client.graphics;

public interface GraphicsFactory {
    Button getButton(ClickHandler handler, int col, int row);
}
