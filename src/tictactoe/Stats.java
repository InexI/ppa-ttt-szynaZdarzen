package tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import tictactoe.event.GameWonEvent;
import tictactoe.event.RequestNewGameEvent;
import tictactoe.event.SwitchTrybeEvent;

/**
 * Created by pwilkin on 15-Nov-18.
 */
public class Stats {

    int krzyzykWins = 0;
    int kolkoWins = 0;

    protected ApplicationController mainController;

    public void setMainController(ApplicationController mainController) {
        this.mainController = mainController;
        mainController.registerHandler(GameWonEvent.class, event -> updateWins(event.getWhoWon()));
    }

    @FXML
    protected Label krzyzyk;

    @FXML
    protected Label kolko;

    @FXML
    protected Button twoP;

    protected boolean comp = true;

    public void newGame(ActionEvent actionEvent) {
        mainController.handleEvent(new RequestNewGameEvent());
    }

    private void updateWins(Player wins) {
        if (wins == Player.CROSS) {
            krzyzykWins++;
        } else {
            kolkoWins++;
        }
        updateLabels();
    }

    private void updateLabels() {
        krzyzyk.setText("Gracz X: " + krzyzykWins);
        kolko.setText("Gracz O: " + kolkoWins);
    }

    public void switchTrybe(ActionEvent actionEvent) {
        mainController.handleEvent(new SwitchTrybeEvent());
        if (comp) {
            comp = false;
            twoP.setText("Komputer");
        } else {
            comp = true;
            twoP.setText("Gra na 2");
        }

    }
}
