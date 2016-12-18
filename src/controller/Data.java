package controller;

/**
 * Created by lapost48 on 12/14/2016.
 */
public class Data {

    int winner;

    private int[][][][] subBoards;
    private int[][] subBoardWinners;

    public Data(int[][][][] miniBoards, int[][] winners) {
        winner = 0;
        subBoards = miniBoards;
        subBoardWinners = winners;
    }

    public boolean hasWinner() {
        return winner != 0;
    }

    public int getWinner() {
        return winner;
    }

    public Packet getPacket(int i, int j) {
        return new Packet(subBoards[i][j], subBoardWinners[i][j]);
    }

}
