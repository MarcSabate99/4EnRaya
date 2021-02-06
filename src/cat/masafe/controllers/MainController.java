package cat.masafe.controllers;

import cat.masafe.Controller;
import cat.masafe.interfaces.Injector;
import cat.masafe.models.GameModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Controller implements Initializable, Injector<GameModel> {


    private GameModel gameModel;

    @Override
    public void inject(GameModel obj) {
        gameModel = obj;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleClickPlayBtn(ActionEvent event) throws IOException {
        FXMLLoader gameView = new FXMLLoader(getClass().getResource("../views/game.fxml"));
        GameController gameController = new GameController();
        gameController.inject(gameModel);
        gameController.preLoad();
        gameView.setController(gameController);
        AnchorPane gamePanel = gameView.load();
        Stage gameStage = new Stage();
        gameStage.setTitle("Jugando!");
        gameStage.setResizable(false);
        gameStage.setScene(new Scene(gamePanel, 815, 525));
        gameStage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


}
