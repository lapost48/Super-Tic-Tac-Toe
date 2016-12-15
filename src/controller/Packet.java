package controller;

import model.Player;

/**
 * Created by lapost48 on 12/15/2016.
 */
public class Packet {

    private int[][] tiles;
    private Player winner;

    public Packet(int[][] tiles, Player winner) {
        this.tiles = tiles;
        this.winner = winner;
    }

    public Player getSubWinner() {
        return winner;
    }

    public boolean isComplete() {
        return winner != null;
    }

    public int[][] getSubBoard() {
        return tiles;
    }

}
