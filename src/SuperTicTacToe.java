import javax.swing.*;
import java.awt.*;

/**
 * Created by lapost48 on 12/13/2016.
 */
public class SuperTicTacToe {

    public static Player turnPlayer = Player.X;

    private static MiniBoard[] boards = new MiniBoard[9];

    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Super Tic-Tac-Toe");
        frame.setLayout(new GridLayout(3, 3));
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                createBoard(3*i + j);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private static void createBoard(int index) {
        boards[index] = new MiniBoard(index);
        frame.add(boards[index]);
    }

    public static void togglePlayer(int index, int i, int j) {
        for(MiniBoard b: boards)
            b.disableBoard();
        boards[index].checkWin();
        if(boards[i*3 + j].getWinner() == null)
            boards[i*3 + j].enableBoard();
        else
            for(MiniBoard b: boards)
                b.enableBoard();
        checkWin();
        if(turnPlayer == Player.X)
            turnPlayer = Player.O;
        else
            turnPlayer = Player.X;
    }

    private static void checkWin() {
        Player winner = null;
        for(int i = 0; i < 3; i++) {
            // Check Rows
            if (boards[i*3].getWinner() == boards[i*3 + 1].getWinner() && boards[i*3 + 1].getWinner() == boards[i*3 + 2].getWinner())
                if (boards[i*3].getWinner() == Player.X)
                    winner = Player.X;
                else if (boards[i*3].getWinner() == Player.O)
                    winner = Player.O;
            // Check Columns
            if (boards[0 + i].getWinner() == boards[3 + i].getWinner() && boards[3 + i].getWinner() == boards[6 + i].getWinner())
                if (boards[0 + i].getWinner() == Player.X)
                    winner = Player.X;
                else if (boards[0 + i].getWinner() == Player.O)
                    winner = Player.O;
        }
        // Check Diagonals
        if (boards[0].getWinner() == boards[4].getWinner() && boards[4].getWinner() == boards[8].getWinner())
            if (boards[0].getWinner() == Player.X)
                winner = Player.X;
            else if (boards[0].getWinner() == Player.O)
                winner = Player.O;
        if (boards[6].getWinner() == boards[4].getWinner() && boards[4].getWinner() == boards[2].getWinner())
            if (boards[6].getWinner() == Player.X)
                winner = Player.X;
            else if (boards[6].getWinner() == Player.O)
                winner = Player.O;
        if(winner != null) {
            System.out.println(turnPlayer + " Wins!");
            for(MiniBoard b: boards)
                b.disableBoard();
        }
    }

}
