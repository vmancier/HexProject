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
    private boolean done;

    public HexModel() {
        player1 = new Player(1);
        player2 = new Player(2);
        currentPlayer = player1;
        gridHex = new Grid();
        /*gameLoop();*/
    }

    public Grid getGridHex() {
        return gridHex;
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