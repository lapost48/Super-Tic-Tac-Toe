package view;

/**
 * Created by lapost48 on 12/14/2016.
 */
public class GUIView implements View {

    private boolean guiPlayer1;
    private boolean guiPlayer2;

    public GUIView(boolean p1, boolean p2) {
        guiPlayer1 = p1;
        guiPlayer2 = p2;
    }

    public boolean hasPlayer1() {
        return guiPlayer1;
    }

    public boolean hasPlayer2() {
        return guiPlayer2;
    }
}
