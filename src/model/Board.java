package model;

import controller.Data;
import controller.Input;
/**
 * Created by lapost48 on 12/13/2016.
 */
public class Board implements Model {

    private MiniBoard[][] boards;
    private int lastClick;

    public Board() {
        boards = new MiniBoard[3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                boards[i][j] = new MiniBoard();
        lastClick = 9;
    }

    public Data getData() {
        int[][] winners = new int[3][3];
        int[][][][] values = new int[3][3][3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                winners[i][j] = boards[i][j].getWinner();
                values[i][j] = boards[i][j].getValues();
            }
        return new Data(values, winners, lastClick);
    }

    public void update(Input input, boolean turnX) {
        int[] loc = input.getLastClick();
        int x = loc[0] / 3;
        int y = loc[1] / 3;

        int i = loc[0] % 3;
        int j = loc[1] % 3;

        boards[x][y].update(i, j, turnX ? 1 : 2);

        if(boards[i][j].getWinner() > 0)
            lastClick = 9;
        else
            lastClick = 3 * i + j;
        System.out.println(i + ", " + j + ", " + lastClick);
    }

}
