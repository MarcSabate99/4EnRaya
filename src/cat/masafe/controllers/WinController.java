package cat.masafe.controllers;

import cat.masafe.Controller;
import cat.masafe.interfaces.Injector;
import cat.masafe.models.WinModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class WinController extends Controller implements Initializable, Injector<WinModel> {

    private WinModel winModel;

    @FXML
    public Text winnerName;

    @FXML
    public Button color;

    @Override
    public void inject(WinModel obj) {
        winModel = obj;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void init(String name) {
        winnerName.setText("Ganador - " + name);
        color.getStyleClass().add(name);
    }
}
