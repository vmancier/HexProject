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
        if (nbNextToCell(gridHex.getMatrix()[r][c]) > 0) {// si la cellule a des voisins
            if (nbNextToCell(gridHex.getMatrix()[r][c]) == 1) {//s'il n'y a qu'un seul voisin
                boolean found = false;
                for (ArrayList<Cell> co : currentPlayer.getBlocks()) {// parcours de la liste de blocs de cellules
                    for (Cell cell : co) {//parcours des blocs de cellules
                        //recherche d'une cellule voisine de la cellule clickée
                        if (cell.getCenterX() < gridHex.getMatrix()[r][c].getCenterX() + 2 * Entities.CELL_SIZE
                                && cell.getCenterX() > gridHex.getMatrix()[r][c].getCenterX() - 2 * Entities.CELL_SIZE
                                && cell.getCenterY() < gridHex.getMatrix()[r][c].getCenterY() + 2 * Entities.CELL_SIZE
                                && cell.getCenterY() > gridHex.getMatrix()[r][c].getCenterY() - 2 * Entities.CELL_SIZE) {

                            found = true; //cellule voisine trouvée
                        }
                    }
                    if (found == true) {//si une cellule voisine a été trouvée
                        co.add(gridHex.getMatrix()[r][c]);//ajout de la cellule clickée au bloc de cellules de la cellule voisine
                    }
                }
            } else {//s'il y a plusieurs voisins
                ArrayList<Cell> cellPile = new ArrayList<Cell>();//bloc de fusion
                ArrayList<ArrayList<Cell>> basketArray = new ArrayList<ArrayList<Cell>>(); //liste des blocs à supprimer
                boolean found = false;
                for (ArrayList<Cell> co : currentPlayer.getBlocks()) {// parcours de la liste de blocs de cellules
                    for (Cell cell : co) {//parcours des blocs de cellules
                        //recherche d'une cellule voisine de la cellule clickée
                        if (cell.getCenterX() < gridHex.getMatrix()[r][c].getCenterX() + 2 * Entities.CELL_SIZE
                                && cell.getCenterX() > gridHex.getMatrix()[r][c].getCenterX() - 2 * Entities.CELL_SIZE
                                && cell.getCenterY() < gridHex.getMatrix()[r][c].getCenterY() + 2 * Entities.CELL_SIZE
                                && cell.getCenterY() > gridHex.getMatrix()[r][c].getCenterY() - 2 * Entities.CELL_SIZE) {

                            found = true;//cellule voisine trouvée
                        }
                    }
                    if (found == true) {//si une cellule voisine a été trouvée
                        cellPile.addAll(co);//ajout de toutes les cellules du bloc de la cellule voisine au bloc de fusion
                        basketArray.add(co);//ajout du bloc à la liste des blocs à supprimer
                    }
                }
                for (ArrayList<Cell> co : basketArray) {//parcours des blocs à supprimer
                    currentPlayer.getBlocks().remove(co);//suppression des blocs
                }
                cellPile.add(gridHex.getMatrix()[r][c]);//ajout de la case clickée au bloc de fusion
                currentPlayer.getBlocks().add(cellPile);//ajout du bloc de fusion à la liste des blocs
            }
        }
        else {// si la cellule n'a pas de voisins
            ArrayList<Cell> cells = new ArrayList<Cell>(); //création d'un bloc de cellules
            cells.add(gridHex.getMatrix()[r][c]);//ajout de la cellule clickée dans ce bloc
            currentPlayer.getBlocks().add(cells);//ajout du bloc à la liste des blocs du joueur courant
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
        for (ArrayList<Cell> co : currentPlayer.getBlocks()) {
            for (Cell cell : co) {
                if (cell != c) {
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
        for (ArrayList<Cell> co : currentPlayer.getBlocks()) {// parcours de la liste de blocs de cellules
            for (Cell cell : co) {//parcours des blocs de cellules
                if (currentPlayer == player1) {// si le joueur 1 joue
                    if (cell.getPosX() == 0) {// si une des cellule est en bas à gauche
                        start = true; //elle se trouve à la position de départ
                    }
                    if (cell.getPosX() == Entities.COLUMNS_NUMBER - 1) {// si une des cellule est en haut à droite
                        finish = true;//elle se trouve à la position d'arrivée
                    }
                } else {//si le joueur 2 joue
                    if (cell.getPosY() == 0) { // si une des cellule est en haut à gauche
                        start = true;//elle se trouve à la position de départ
                    }
                    if (cell.getPosY() == Entities.ROWS_NUMBER - 1) {// si une des cellule est en bas à droite
                        finish = true;//elle se trouve à la position d'arrivée
                    }
                }
            }
            if (start && finish) {// si les bouts de la chaine sont au départ et à l'arrivée
                win = true; // le joueur a gagné
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