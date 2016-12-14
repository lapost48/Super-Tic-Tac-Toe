package model;

/**
 * Created by lapost48 on 12/13/2016.
 */
class MiniBoard {

    Player winner;

    private Player[][] moves;
    private int moveCount;

    protected MiniBoard() {
        moveCount = 0;
        moves = new Player[3][3];
        for(Player[] row : moves)
            for(Player p : row)
                p = Player.NONE;
        winner = null;
    }

    private void setWinner(Player win) {
        winner = win;
    }

    public Player getWinner() {
        return winner;
    }

    protected void checkWin() {
        for(int i = 0; i < 3; i++) {
            // Check Rows
            if (moves[i][0] == moves[i][1] && moves[i][1] == moves[i][2])
                setWinner(moves[i][0]);
            // Check Columns
            if (moves[0][i] == moves[1][i] && moves[1][i] == moves[2][i])
                setWinner(moves[0][i]);
        }
        // Check Diagonals
        if (moves[0][0] == moves[1][1] && moves[1][1] == moves[2][2])
            setWinner(moves[0][0]);
        if (moves[0][2] == moves[1][1] && moves[1][1] == moves[2][0])
            setWinner(moves[0][2]);

        if(winner == null && moveCount == 9)
            setWinner(Player.TIE);
    }

}
