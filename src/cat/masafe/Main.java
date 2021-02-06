package cat.masafe;

import cat.masafe.controllers.MainController;
import cat.masafe.models.GameModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader mainView = new FXMLLoader(getClass().getResource("views/main.fxml"));
        MainController mainController = new MainController();
        GameModel gameModel = new GameModel();
        mainController.inject(gameModel);
        mainView.setController(mainController);
        Parent root = mainView.load();
        primaryStage.setTitle("4 en Raya");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 730, 730));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
