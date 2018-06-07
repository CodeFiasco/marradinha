package org.academiadecodigo.bootcamp.marralhinha.client.graphics;

import org.academiadecodigo.bootcamp.marralhinha.client.graphics.swing.SBoard;

public class Test implements ClickHandler {

    private Board board;

    public Test(Board board) {
        this.board = board;
    }

    public static void main(String[] args) {

        SBoard board = new SBoard();
        board.init("resources/board.txt");
        board.setClickHandler(new Test(board));

        board.fillButton(0, Color.BLUE);
        board.fillButton(1, Color.BLUE);
        board.fillButton(2, Color.BLUE);
        board.fillButton(3, Color.BLUE);
        board.fillButton(4, Color.BLUE);

        board.fillButton(25, Color.YELLOW);
        board.fillButton(41, Color.YELLOW);
        board.fillButton(45, Color.YELLOW);
        board.fillButton(60, Color.YELLOW);
        board.fillButton(64, Color.YELLOW);

        board.fillButton(40, Color.GREEN);
        board.fillButton(44, Color.GREEN);
        board.fillButton(59, Color.GREEN);
        board.fillButton(63, Color.GREEN);
        board.fillButton(79, Color.GREEN);

        board.fillButton(100, Color.RED);
        board.fillButton(101, Color.RED);
        board.fillButton(102, Color.RED);
        board.fillButton(103, Color.RED);
        board.fillButton(104, Color.RED);
    }

    @Override
    public void clicked(ClickEvent event) {
        board.fillButton(event.getId(), Color.RED);
    }
}
