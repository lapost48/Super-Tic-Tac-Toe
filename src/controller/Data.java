package controller;

import model.Player;

/**
 * Created by lapost48 on 12/14/2016.
 */
public class Data {

    Player winner;

    private int[][][][] subBoards;
    private Player[][] subBoardWinners;

    public Data() {
        winner = null;
        subBoards = new int[3][3][3][3];
        subBoardWinners = new Player[3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                subBoardWinners[i][j] = null;
    }

    public boolean hasWinner() {
        return winner != null;
    }

    public Player getWinner() {
        return winner;
    }

    public Packet getPacket(int i, int j) {
        return new Packet(subBoards[i][j], subBoardWinners[i][j]);
    }

}
