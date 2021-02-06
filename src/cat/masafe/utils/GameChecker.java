package cat.masafe.utils;

import cat.masafe.models.GameModel;

import java.io.IOException;

public class GameChecker {

    private final GameModel gModel;

    public GameChecker(GameModel gameModel){
        gModel = gameModel;
    }

    //TODO: REFACTOR xd
    public void checkHorizontalWin(int[][] map, int row, boolean gameFinished, int playerOneConsecutiveAssert, int playerTwoConsecutiveAssert) {
        for (int y = 0; y < map.length; y++) {
            if (map[row][y] == 2) {
                //yellow
                playerOneConsecutiveAssert++;
            } else {
                playerOneConsecutiveAssert = 0;
            }
            if (playerOneConsecutiveAssert == 4) {
                //endGame
                try {
                    gModel.finish("yellow");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gameFinished = true;
            }
            if (!gameFinished) {
                if (map[row][y] == 1) {
                    //red
                    playerTwoConsecutiveAssert++;
                } else {
                    playerTwoConsecutiveAssert = 0;
                }
                if (playerTwoConsecutiveAssert == 4) {
                    //endGame
                    try {
                        gModel.finish("red");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    gameFinished = true;
                }
            }
        }
    }

    public void checkVerticalWin(int[][] map, int column, boolean gameFinished, int playerOneConsecutiveAssert, int playerTwoConsecutiveAssert) {
        for (int x = 0; x < map.length; x++) {
            if (map[x][column] == 2) {
                //yellow
                playerOneConsecutiveAssert++;
            } else {
                playerOneConsecutiveAssert = 0;
            }
            if (playerOneConsecutiveAssert == 4) {
                //endGame
                try {
                    gModel.finish("yellow");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gameFinished = true;
            }
            if (!gameFinished) {
                if (map[x][column] == 1) {
                    //red
                    playerTwoConsecutiveAssert++;
                } else {
                    playerTwoConsecutiveAssert = 0;
                }
                if (playerTwoConsecutiveAssert == 4) {
                    //endGame
                    try {
                        gModel.finish("red");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    gameFinished = true;
                }
            }
        }
    }

    public void checkDiagonalLeftToRightWin(int[][] map, int row, int column, boolean gameFinished, int playerOneConsecutiveAssert, int playerTwoConsecutiveAssert) {
        int auxColumn = column;
        int auxRow = row;
        while (auxColumn > 0 && auxRow > 0) {
            auxColumn--;
            auxRow--;
        }
        while (auxRow < map.length && auxColumn < map[auxRow].length) {
            if (map[auxRow][auxColumn] == 2) {
                //yellow
                playerOneConsecutiveAssert++;
            } else {
                playerOneConsecutiveAssert = 0;
            }
            if (playerOneConsecutiveAssert == 4) {
                //endGame
                try {
                    gModel.finish("yellow");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gameFinished = true;
            }
            if (!gameFinished) {
                if (map[auxRow][auxColumn] == 1) {
                    playerTwoConsecutiveAssert++;
                } else {
                    playerTwoConsecutiveAssert = 0;
                }
                if (playerTwoConsecutiveAssert == 4) {
                    //endGame
                    try {
                        gModel.finish("red");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    gameFinished = true;
                }
            }
            auxColumn++;
            auxRow++;
        }
    }

    public void checkDiagonalRightToLeftWin(int[][] map, int row, int column, boolean gameFinished, int playerOneConsecutiveAssert, int playerTwoConsecutiveAssert) {
        int auxColumn = column;
        int auxRow = row;
        while (auxColumn > 0 && auxRow < map.length) {
            auxColumn--;
            auxRow++;
        }

        while (auxRow > -1 && auxColumn < map.length) {
            if (map[auxColumn][auxRow] == 2) {
                //yellow
                playerOneConsecutiveAssert++;
            } else {
                playerOneConsecutiveAssert = 0;
            }
            if (playerOneConsecutiveAssert == 4) {
                //endGame
                try {
                    gModel.finish("yellow");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                gameFinished = true;
            }
            if (!gameFinished) {
                if (map[auxColumn][auxRow] == 1) {
                    //red
                    playerTwoConsecutiveAssert++;
                } else {
                    playerTwoConsecutiveAssert = 0;
                }
                if (playerTwoConsecutiveAssert == 4) {
                    //endGame
                    try {
                        gModel.finish("red");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    gameFinished = true;
                }
            }
            auxColumn++;
            auxRow--;
        }
    }
}
