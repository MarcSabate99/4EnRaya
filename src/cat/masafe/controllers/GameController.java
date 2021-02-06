package cat.masafe.controllers;

import cat.masafe.Controller;
import cat.masafe.interfaces.Injector;
import cat.masafe.models.GameModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController extends Controller implements Initializable, Injector<GameModel> {

    private GameModel gameModel;

    @Override
    public void inject(GameModel obj) {
        gameModel = obj;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleGenerateBall(ActionEvent event){
        this.gameModel.generateBallOnClick(event);
    }

    public void preLoad(){
        this.gameModel.initGame();
    }


}
