package controller;

import model.Model;
import model.Board;
import view.View;
import view.GUIView;

/**
 * Created by lapost48 on 12/13/2016.
 */
public class Controller {

    private static View view = new GUIView(true, true);

    private static boolean gameWin = false;

    private static Model model = new Board();
    private static boolean player1Turn = true;

    public static void main(String[] args) {

        Data data = model.getData();

        do {
            view.display(data);

            // Get input from proper sources
            Input input = null;
            if(player1Turn)
                if(view.hasPlayer1())
                    input = view.getInput();
            else
                if(view.hasPlayer2())
                    input = view.getInput();

            if(input == null)
                input = aiInput(data);

            model.update(input);

            data = model.getData();
            gameWin = data.hasWinner();

            toggleTurnPlayer();
        }while(!gameWin);

        endGame(data);

    }

    private static Input aiInput(Data data) {
        return null;
    }

    private static void toggleTurnPlayer() {
        player1Turn = !player1Turn;
    }

    private static void endGame(Data data) {

    }

}
