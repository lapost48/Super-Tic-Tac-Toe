package controller;

import model.Player;

/**
 * Created by lapost48 on 12/14/2016.
 */
public class Data {

    Player winner = null;

    public Data() {
        winner = null;
    }

    public boolean hasWinner() {
        return winner != null;
    }

    public Player getWinner() {
        return winner;
    }

}
