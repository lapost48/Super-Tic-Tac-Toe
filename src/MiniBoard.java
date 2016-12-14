import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lapost48 on 12/13/2016.
 */
public class MiniBoard extends JPanel {

    Player winner;
    JButton[][] buttons;

    private int index;
    private int moveCount;

    public MiniBoard(int index) {
        this.index = index;
        moveCount = 0;
        winner = null;
        buttons = new JButton[3][3];
        this.setLayout(new GridLayout(3, 3));
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                createButton(i, j);
                this.add(buttons[i][j]);
            }
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }

    private void createButton(int i, int j) {
        JButton b = new JButton("");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(b.getText().equals("")) {
                    b.setText(SuperTicTacToe.turnPlayer.toString());
                    moveCount++;
                    SuperTicTacToe.togglePlayer(index, i, j);
                }
            }
        });
        buttons[i][j] = b;
    }

    public void enableBoard() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                buttons[i][j].setEnabled(true);
    }

    public void disableBoard() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                buttons[i][j].setEnabled(false);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(winner == Player.X)
            ex(g);
        if(winner == Player.O)
            oh(g);
    }

    public void ex(Graphics g)
    {
        g.drawLine(0, 0, getWidth(), getHeight());
        g.drawLine(0, getHeight(), getWidth(), 0);
    }

    public void oh(Graphics g)
    {
        g.drawOval(0, 0, getWidth(), getHeight());
    }

    private void setWinner(Player win) {
        this.removeAll();
        this.repaint();
        this.setLayout(new FlowLayout());
        winner = win;
    }

    public Player getWinner() {
        return winner;
    }

    public void checkWin() {
        for(int i = 0; i < 3; i++) {
            // Check Rows
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][1].getText().equals(buttons[i][2].getText()))
                if (buttons[i][0].getText().equals(Player.X.toString()))
                    setWinner(Player.X);
                else if (buttons[i][0].getText().equals(Player.O.toString()))
                    setWinner(Player.O);
            // Check Columns
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[1][i].getText().equals(buttons[2][i].getText()))
                if (buttons[0][i].getText().equals(Player.X.toString()))
                    setWinner(Player.X);
                else if (buttons[0][i].getText().equals(Player.O.toString()))
                    setWinner(Player.O);
        }
            // Check Diagonals
            if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()))
                if (buttons[0][0].getText().equals(Player.X.toString()))
                    setWinner(Player.X);
                else if (buttons[0][0].getText().equals(Player.O.toString()))
                    setWinner(Player.O);
            if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText()))
                if (buttons[0][2].getText().equals(Player.X.toString()))
                   setWinner(Player.X);
                else if (buttons[0][2].getText().equals(Player.O.toString()))
                    setWinner(Player.O);

        if(winner == null && moveCount == 9)
            setWinner(Player.TIE);
    }

}
