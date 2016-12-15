package view;

import controller.Input;
import controller.Data;

/**
 * Created by lapost48 on 12/13/2016.
 */
public interface View {

    public void display(Data data);

    public Input getInput() throws NoInputException;

    public boolean hasPlayer1();

    public boolean hasPlayer2();

}
