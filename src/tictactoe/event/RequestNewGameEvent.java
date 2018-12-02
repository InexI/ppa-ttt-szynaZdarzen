package tictactoe.event;

/**
 * Created by pwilkin on 22-Nov-18.
 */
public class RequestNewGameEvent implements TicTacToeEvent {

    protected boolean comp = true;

    public void setComp(boolean comp) {
        this.comp = comp;
    }

    public boolean isComp() {
        return comp;
    }
}
