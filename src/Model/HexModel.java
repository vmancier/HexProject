package Model;

/**
 * Created by Valentin on 14/10/2015.
 */

import Application.Entities;
import Controller.HexController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

public class HexModel extends Observable {
    Grid gridHex;
    static Player player1;
    static Player player2;
    static Player currentPlayer;

    public HexModel() {
        player1 = new Player(1);
        player2 = new Player(2);
        currentPlayer = player1;
        gridHex = new Grid();

    }

    public Grid getGridHex() {
        return gridHex;
    }

    public void groupCells(int r, int c) {

        if (nbNextToCell(gridHex.getMatrix()[r][c]) > 0) {
            if (nbNextToCell(gridHex.getMatrix()[r][c]) == 1) {
                boolean finded = false;
                for (ArrayList<Cell> co : currentPlayer.getBlocks()) {
                    for (Cell cell : co) {
                        if (cell.getCenterX() < gridHex.getMatrix()[r][c].getCenterX() + 2 * Entities.CELL_SIZE
                                && cell.getCenterX() > gridHex.getMatrix()[r][c].getCenterX() - 2 * Entities.CELL_SIZE
                                && cell.getCenterY() < gridHex.getMatrix()[r][c].getCenterY() + 2 * Entities.CELL_SIZE
                                && cell.getCenterY() > gridHex.getMatrix()[r][c].getCenterY() - 2 * Entities.CELL_SIZE) {

                            finded = true;
                        }
                    }
                    if (finded == true) {
                        co.add(gridHex.getMatrix()[r][c]);
                    }
                }
            } else {
                ArrayList<Cell> cellPile = new ArrayList<Cell>();
                boolean finded = false;
                for (ArrayList<Cell> co : currentPlayer.getBlocks()) {
                    for (Cell cell : co) {
                        if (cell.getCenterX() < gridHex.getMatrix()[r][c].getCenterX() + 2 * Entities.CELL_SIZE
                                && cell.getCenterX() > gridHex.getMatrix()[r][c].getCenterX() - 2 * Entities.CELL_SIZE
                                && cell.getCenterY() < gridHex.getMatrix()[r][c].getCenterY() + 2 * Entities.CELL_SIZE
                                && cell.getCenterY() > gridHex.getMatrix()[r][c].getCenterY() - 2 * Entities.CELL_SIZE) {

                            finded = true;
                        }
                    }
                    if (finded == true) {
                        cellPile.addAll(co);
                        co.clear();
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
        //System.out.println(currentPlayer.getColor());
        boolean win = false;
        boolean start=false;
        boolean finish=false;
        for (ArrayList<Cell> co : currentPlayer.getBlocks()) {
            for (Cell cell : co) {
                if (currentPlayer == player1) {
                    if (cell.getPosX() == 0 ) {
                        start=true;
                    }
                    if(cell.getPosX() == Entities.COLUMNS_NUMBER - 1){
                        finish=true;
                    }
                }
                else{
                    if (cell.getPosY() == 0 ) {
                        start=true;
                    }
                    if(cell.getPosY() == Entities.ROWS_NUMBER- 1){
                        finish=true;
                    }
                }
            }
            if (start && finish){
                win=true;
            }
            start=false;
            finish=false;
        }
        return win;
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