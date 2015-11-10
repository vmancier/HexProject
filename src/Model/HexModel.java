package Model;

/**
 * Created by Valentin on 14/10/2015.
 */

import java.util.Observable;

public class HexModel extends Observable {
    Grid gridHex;
    static Player player1;
    static Player player2;
    static Player currentPlayer;
    private boolean done;

    public HexModel() {
        player1 = new Player(1);
        player2 = new Player(2);
        currentPlayer = player1;
        gridHex = new Grid();
        gameLoop();
    }

    public Grid getGridHex() {
        return gridHex;
    }

    public void gameLoop() {
        done = true;
        while (!done) {

        }
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        HexModel.currentPlayer = currentPlayer;

    }

    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }
}