package model;

/**
 * Created by lapost48 on 12/13/2016.
 */
public class Board {

    private MiniBoard[][] boards;

    public Board() {
        boards = new MiniBoard[3][3];
        for(MiniBoard[] row : boards)
            for(MiniBoard mb : row)
                mb = new MiniBoard();
    }

}
