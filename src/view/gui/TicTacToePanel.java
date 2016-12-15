package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lapost48 on 12/15/2016.
 */
class TicTacToePanel extends JPanel {

    private JButton[][] buttons;

    private int[] lastClick;
    private boolean updated;

    TicTacToePanel() {
        super(new GridLayout(3, 3));
        lastClick = new int[2];
        lastClick[0] = -1;
        lastClick[1] = -1;
        updated = false;

        buttons = new JButton[3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                buttons[i][j] = createButton(i, j);
                add(buttons[i][j]);
            }
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private JButton createButton(int i, int j) {
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lastClick[0] = i;
                lastClick[1] = j;
                updated = true;
            }
        });
        return button;
    }

    public boolean isUpdated() {
        return updated;
    }

}
