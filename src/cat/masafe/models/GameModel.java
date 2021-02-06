package cat.masafe.models;

import cat.masafe.controllers.WinController;
import cat.masafe.objects.Player;
import cat.masafe.utils.GameChecker;
import cat.masafe.utils.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

import java.io.IOException;

public class GameModel {

    private boolean gameFinished;
    private int map[][];
    private final int PLAYER_ONE_TURN = 1;
    private final int PLAYER_ONE_BALL = 1;
    private final int PLAYER_TWO_TURN = 2;
    private final int PLAYER_TWO_BALL = 2;
    private int turn;
    private Player player1;
    private Player player2;
    private boolean firstRound;
    private GameChecker gameChecker;

    public void initGame() {
        gameFinished = false;
        firstRound = true;
        gameChecker = new GameChecker(this);
        generateInternalMap();
        turn = PLAYER_ONE_TURN;
        player1 = new Player("yellow", true);
        player2 = new Player("red");
    }


    private void generateInternalMap() {
        this.map = new int[6][7];
        for (int x = 0; x < this.map.length; x++) {
            for (int y = 0; y < this.map[x].length; y++) {
                this.map[x][y] = 0;
            }
        }
    }

    public void generateBallOnClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        String userData = (String) node.getUserData();
        int column = Tools.getButtonColumn(userData);
        int row = Tools.getButtonRow(userData);
        if (canPlaceHere(column, row)) {
            System.out.println("Can place");
            String colorOfPlayer = getColorOfActualPlayer();
            node.getStyleClass().add(colorOfPlayer);
            changeTurn();
            int valueForMap = (turn == PLAYER_ONE_TURN ? PLAYER_ONE_BALL : PLAYER_TWO_BALL);
            this.map[row][column] = valueForMap;
            firstRound = false;
            checkWining(column, row);
        }

    }

    private void checkWining(int column, int row) {
        int playerOneConsecutiveAssert = 0;
        int playerTwoConsecutiveAssert = 0;
        gameChecker.checkHorizontalWin(this.map, row, gameFinished, playerOneConsecutiveAssert, playerTwoConsecutiveAssert);
        gameChecker.checkVerticalWin(this.map, column, gameFinished, playerOneConsecutiveAssert, playerTwoConsecutiveAssert);
        gameChecker.checkDiagonalLeftToRightWin(this.map, row, column, gameFinished, playerOneConsecutiveAssert, playerTwoConsecutiveAssert);
        gameChecker.checkDiagonalRightToLeftWin(this.map, row, column, gameFinished, playerOneConsecutiveAssert, playerTwoConsecutiveAssert);
    }

    private void changeTurn() {
        if (turn == PLAYER_ONE_TURN) {
            turn = PLAYER_TWO_TURN;
        } else {
            turn = PLAYER_ONE_TURN;
        }
    }

    private String getColorOfActualPlayer() {
        if (firstRound) {
            return player1.getColor();
        }
        if (turn == PLAYER_ONE_TURN) {
            return player1.getColor();
        }
        return player2.getColor();
    }

    private boolean canPlaceHere(int column, int row) {
        if (this.map[row][column] == 0) {
            return true;
        }
        return false;
    }
    /*
    * TODO: Identify player and add color, etc.
     */
    public void finish(String color) throws IOException {
        FXMLLoader finishGameView = new FXMLLoader(getClass().getResource("../views/winner.fxml"));
        WinController winController = new WinController();
        WinModel windModel = new WinModel();
        winController.inject(windModel);
        String winnerPlayer = color;
        finishGameView.setController(winController);
        AnchorPane winingPane = finishGameView.load();
        Stage winingStage = new Stage();
        winingStage.setTitle("Ganador - " + winnerPlayer);
        winingStage.setResizable(false);
        winingStage.setScene(new Scene(winingPane, 500, 500));
        winingStage.show();
        winController.init(winnerPlayer);
    }
}
