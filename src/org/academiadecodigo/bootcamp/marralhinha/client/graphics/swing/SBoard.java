package org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing;

import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Board;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.ClickEvent;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.ClickHandler;
import org.academiadecodigo.bootcamp.marralhinha.client.graphics.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SBoard implements Board, ClickHandler {

    static final int CELL_SIZE = 30;

    private SCanvas canvas;
    private ClickHandler handler;
    private List<SButton> buttons;

    public void init(String file) {
        canvas = new SCanvas();

        BufferedReader reader = null;
        buttons = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            int lineCounter = 0;
            int id = 0;

            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '0') {
                        continue;
                    }

                    SButton button = new SButton(
                            id,
                            i * CELL_SIZE + SCanvas.PADDING,
                            lineCounter * CELL_SIZE + SCanvas.PADDING,
                            this
                    );

                    buttons.add(button);
                    canvas.add(button);

                    id++;
                }

                lineCounter++;
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        canvas.refresh();
    }

    @Override
    public void fillButton(int id, Color color) {
        buttons.get(id).fill(color);
        canvas.refresh();
    }

    @Override
    public void clicked(ClickEvent event) {
        if (handler != null) {
            handler.clicked(event);
        }
    }

    public void setClickHandler(ClickHandler handler) {
        this.handler = handler;
    }
}
