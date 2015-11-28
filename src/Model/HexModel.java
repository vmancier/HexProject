package Model;

/**
 * Created by Valentin on 14/10/2015.
 */

import Application.Entities;
import Controller.HexController;

import java.awt.*;
import java.util.Observable;

public class HexModel extends Observable {
    Grid gridHex;
    static Player player1;
    static Player player2;
    static Player currentPlayer;

    // -- HexModel ----------------------------------
    // Creates a new model
    // ----------------------------------------------
    public HexModel() {
        player1 = new Player(1);
        player2 = new Player(2);
        currentPlayer = player1;    //the player 1 is the first to play
        gridHex = new Grid();
    }

    public boolean playerWin(){
        boolean win = false;
        for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
            if (victory(gridHex.getMatrix()[i][0], Color.BLACK)){
                win = true;
            }
        }
        return win;
    }

    public boolean victory(Cell c, Color color) {
        if (c.getPosX() == Entities.ROWS_NUMBER) {
            return true;
        } else if (c.getColor() == color) {
            return victory(c, color);
        } else {
            return false;
        }
    }

    // -- getGridHex --------------------------------
    // Returns the grid
    // * out-parameters :
    // - "gridHex", Grid : the grid
    // ----------------------------------------------
    public Grid getGridHex() {
        return gridHex;
    }

    // -- getCurrentPlayer --------------------------
    // Returns the player that's currently playing
    // * out-parameters :
    // - "currentPlayer", Player : the current player
    // ----------------------------------------------
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    // -- setCurrentPlayer --------------------------
    // Sets the current player
    // ----------------------------------------------
    public static void setCurrentPlayer(Player currentPlayer) {
        HexModel.currentPlayer = currentPlayer;
    }

    // -- getPlayer1 --------------------------------
    // Returns the player 1
    // * out-parameters :
    // - "player1", Player : the player 1
    // ----------------------------------------------
    public static Player getPlayer1() {
        return player1;
    }

    // -- getPlayer2 --------------------------------
    // Returns the player 2
    // * out-parameters :
    // - "player2", Player : the player 2
    // ----------------------------------------------
    public static Player getPlayer2() {
        return player2;
    }
}