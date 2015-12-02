package Model;

/**
 * Created by Valentin on 14/10/2015.
 */

import Application.Entities;

import java.util.ArrayList;
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
        initModel();
    }

    public void initModel(){
        player1.initPlayer();
        player2.initPlayer();
        currentPlayer = player1;    //the player 1 is the first to play
        gridHex = new Grid();
    }

    public void groupCells(int r, int c) {
        if (nbNextToCell(gridHex.getMatrix()[r][c]) > 0) {
            if (nbNextToCell(gridHex.getMatrix()[r][c]) == 1) {
                boolean found = false;
                for (ArrayList<Cell> co : currentPlayer.getBlocks()) {
                    for (Cell cell : co) {
                        if (cell.getCenterX() < gridHex.getMatrix()[r][c].getCenterX() + 2 * Entities.CELL_SIZE
                                && cell.getCenterX() > gridHex.getMatrix()[r][c].getCenterX() - 2 * Entities.CELL_SIZE
                                && cell.getCenterY() < gridHex.getMatrix()[r][c].getCenterY() + 2 * Entities.CELL_SIZE
                                && cell.getCenterY() > gridHex.getMatrix()[r][c].getCenterY() - 2 * Entities.CELL_SIZE) {

                            found = true;
                        }
                    }
                    if (found == true) {
                        co.add(gridHex.getMatrix()[r][c]);
                    }
                }
            } else {
                ArrayList<Cell> cellPile = new ArrayList<Cell>();
                boolean found = false;
                for (ArrayList<Cell> co : currentPlayer.getBlocks()) {
                    for (Cell cell : co) {
                        if (cell.getCenterX() < gridHex.getMatrix()[r][c].getCenterX() + 2 * Entities.CELL_SIZE
                                && cell.getCenterX() > gridHex.getMatrix()[r][c].getCenterX() - 2 * Entities.CELL_SIZE
                                && cell.getCenterY() < gridHex.getMatrix()[r][c].getCenterY() + 2 * Entities.CELL_SIZE
                                && cell.getCenterY() > gridHex.getMatrix()[r][c].getCenterY() - 2 * Entities.CELL_SIZE) {

                            found = true;
                        }
                    }
                    if (found == true) {
                        cellPile.addAll(co);
                        //co.clear();
                    }
                }
                currentPlayer.getBlocks().add(cellPile);
            }
        } else {
            ArrayList<Cell> cells = new ArrayList<Cell>();
            cells.add(gridHex.getMatrix()[r][c]);
            currentPlayer.getBlocks().add(cells);
        }
    }

    public int nbNextToCell(Cell c) {
        int nbCellsClose = 0;
        for (ArrayList<Cell> co : currentPlayer.getBlocks()) {
            for (Cell cell : co) {
                if (cell.getCenterX() < c.getCenterX() + 2 * Entities.CELL_SIZE
                        && cell.getCenterX() > c.getCenterX() - 2 * Entities.CELL_SIZE
                        && cell.getCenterY() < c.getCenterY() + 2 * Entities.CELL_SIZE
                        && cell.getCenterY() > c.getCenterY() - 2 * Entities.CELL_SIZE) {

                    nbCellsClose++;
                }
            }
        }
        return nbCellsClose;
    }

    public boolean victory() {
        boolean win = false;
        boolean start = false;
        boolean finish = false;
        for (ArrayList<Cell> co : currentPlayer.getBlocks()) {
            for (Cell cell : co) {
                if (currentPlayer == player1) {
                    if (cell.getPosX() == 0) {
                        start = true;
                    }
                    if (cell.getPosX() == Entities.COLUMNS_NUMBER - 1) {
                        finish = true;
                    }
                } else {
                    if (cell.getPosY() == 0) {
                        start = true;
                    }
                    if (cell.getPosY() == Entities.ROWS_NUMBER - 1) {
                        finish = true;
                    }
                }
            }
            if (start && finish) {
                win = true;
            }
            start = false;
            finish = false;
        }
        return win;
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