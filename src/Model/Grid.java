package Model;


import Application.Entities;

/**
 * Created by Eliott on 14/10/2015.
 */
public class Grid {
    private Cell[][] matrix;    //the grid will be represented by a matrix
    private int rows;   //number of rows
    private int columns;    //number of columns

    // -- Grid --------------------------------------
    // Creates a new grid
    // ----------------------------------------------
    public Grid() {
        this.rows = Entities.ROWS_NUMBER;
        this.columns = Entities.COLUMNS_NUMBER;
        this.matrix = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {    //for each row in the grid
            for (int j = 0; j < columns; j++) {     //and for each column
                matrix[i][j] = new Cell(i, j,   //a cell is created and added to the matrix
                        Entities.ROW_POS_X * i + Entities.COLUMN_POS_X * j + Entities.GRID_POS_X,
                        Entities.COLUMN_POS_Y * j + Entities.ROW_POS_Y * i + Entities.GRID_POS_Y);
            }
        }
    }

    // -- getMatrix ----------------------------------
    // Returns the matrix
    // * out-parameters :
    // - "matrix", Matrix : the matrix
    // ----------------------------------------------
    public Cell[][] getMatrix() {
        return matrix;
    }

}
