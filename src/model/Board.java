package model;

import controller.Data;
import controller.Input;
/**
 * Created by lapost48 on 12/13/2016.
 */
public class Board implements Model {

    private MiniBoard[][] boards;

    public Board() {
        boards = new MiniBoard[3][3];
        for(MiniBoard[] row : boards)
            for(MiniBoard mb : row)
                mb = new MiniBoard();
    }

    public Data getData() {
        return new Data();
    }

    public void update(Input input) {

    }

}
