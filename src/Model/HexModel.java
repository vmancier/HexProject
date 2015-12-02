package Model;

/**
 * Created by Eliott and Valentin on 14/10/2015.
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

    // -- initModel ---------------------------------
    // Initializes the model
    // ----------------------------------------------
    public void initModel() {
        player1.initPlayer();
        player2.initPlayer();
        currentPlayer = player1;    //the player 1 is the first to play
        gridHex = new Grid();
    }

    // -- groupCells --------------------------------
    // Initializes the model
    // * in-parameters :
    // - "r", int : column's index
    // - "c", int : row's index
    // ----------------------------------------------
    public void groupCells(int r, int c) {
        if (nbNextToCell(gridHex.getMatrix()[r][c]) > 0) {  //if the cell got close cells
            if (nbNextToCell(gridHex.getMatrix()[r][c]) == 1) { //if there is only one neighbour
                boolean found = false;
                for (ArrayList<Cell> co : currentPlayer.getBlocks()) {  //browsing the list of cell's blocks
                    for (Cell cell : co) {  //browsing the cell's blocks
                        //searching for a close cell of the clicked cell
                        if (cell.getCenterX() < gridHex.getMatrix()[r][c].getCenterX() + 2 * Entities.CELL_SIZE
                                && cell.getCenterX() > gridHex.getMatrix()[r][c].getCenterX() - 2 * Entities.CELL_SIZE
                                && cell.getCenterY() < gridHex.getMatrix()[r][c].getCenterY() + 2 * Entities.CELL_SIZE
                                && cell.getCenterY() > gridHex.getMatrix()[r][c].getCenterY() - 2 * Entities.CELL_SIZE) {

                            found = true;   //close cell found
                        }
                    }
                    if (found == true) {    //if a a close cell of the clicked cell has been found
                        co.add(gridHex.getMatrix()[r][c]);  //then adding the clicked cell to the block of cells of the close cell
                    }
                }
            } else {    //if there are several close cells
                ArrayList<Cell> cellPile = new ArrayList<>();   //fusion block
                ArrayList<ArrayList<Cell>> basketArray = new ArrayList<>(); //list of blocks to delete
                boolean found = false;
                for (ArrayList<Cell> co : currentPlayer.getBlocks()) {  //browsing the list of cell's blocks
                    for (Cell cell : co) {  //browsing the cell's blocks
                        //searching for a close cell of the clicked cell
                        if (cell.getCenterX() < gridHex.getMatrix()[r][c].getCenterX() + 2 * Entities.CELL_SIZE
                                && cell.getCenterX() > gridHex.getMatrix()[r][c].getCenterX() - 2 * Entities.CELL_SIZE
                                && cell.getCenterY() < gridHex.getMatrix()[r][c].getCenterY() + 2 * Entities.CELL_SIZE
                                && cell.getCenterY() > gridHex.getMatrix()[r][c].getCenterY() - 2 * Entities.CELL_SIZE) {

                            found = true;   //close cell found
                        }
                    }
                    if (found == true) {    //if a a close cell of the clicked cell has been found
                        cellPile.addAll(co);    //adding all the block's cells of the close cell to the fusion block
                        basketArray.add(co);    //adding the block to the list of blocks to delete
                    }
                }
                for (ArrayList<Cell> co : basketArray) {    //browsing the list blocks to delete
                    currentPlayer.getBlocks().remove(co);   //deleting the blocks
                }
                cellPile.add(gridHex.getMatrix()[r][c]);    //adding the clicked cell to the fusion block
                currentPlayer.getBlocks().add(cellPile);    //adding the fusion block to the list of blocks
            }
        } else {    //if the cell hasn't any close cell
            ArrayList<Cell> cells = new ArrayList<>();  //creating a block of cells
            cells.add(gridHex.getMatrix()[r][c]);   //adding the clicked cell to this block
            currentPlayer.getBlocks().add(cells);   //adding this block to the current player's list of blocks
        }
    }

    // -- nbNextToCell ------------------------------
    // Searches closes cells of a cell
    // * in-parameters :
    // - "c", Cell : the method will be searching for closes cell of this cell "c"
    // * out-parameters :
    // - "nbCellsClose", int : number of cells close to the starting cell "c"
    // ----------------------------------------------
    public int nbNextToCell(Cell c) {
        int nbCellsClose = 0;
        for (ArrayList<Cell> co : currentPlayer.getBlocks()) {  //browsing the list of cell's blocks
            for (Cell cell : co) {  //browsing the cell's blocks
                if (cell != c) {    //verifying the cell is different of itself
                    if (cell.getCenterX() < c.getCenterX() + 2 * Entities.CELL_SIZE
                            && cell.getCenterX() > c.getCenterX() - 2 * Entities.CELL_SIZE
                            && cell.getCenterY() < c.getCenterY() + 2 * Entities.CELL_SIZE
                            && cell.getCenterY() > c.getCenterY() - 2 * Entities.CELL_SIZE) {
                        nbCellsClose++;
                    }
                }
            }
        }
        return nbCellsClose;
    }


    // -- victory -----------------------------------
    // Determines if a player won or not
    // * out-parameters :
    // - "win", boolean : true if the player has won, false on the contrary
    // ----------------------------------------------
    public boolean victory() {
        boolean win = false;
        boolean start = false;
        boolean finish = false;
        for (ArrayList<Cell> co : currentPlayer.getBlocks()) {  //browsing the list of cell's blocks
            for (Cell cell : co) {  //browsing the cell's blocks
                if (currentPlayer == player1) { //if the player 1 is playing
                    if (cell.getPosX() == 0) {  //if one of the cells is down left
                        start = true; //it becomes the starting position
                    }
                    if (cell.getPosX() == Entities.COLUMNS_NUMBER - 1) {    //if one of the cell is up right
                        finish = true;  //it becomes the finish position
                    }
                } else {    //if the player 2 is playing
                    if (cell.getPosY() == 0) {  //if one of the cells is up left
                        start = true;   //it becomes the starting position
                    }
                    if (cell.getPosY() == Entities.ROWS_NUMBER - 1) {   //if one of the cell is down right
                        finish = true;  //it becomes the finish position
                    }
                }
            }
            if (start && finish) {  //if the extremities of the chain are at the starting position and the finish position
                win = true; //then the player has won
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