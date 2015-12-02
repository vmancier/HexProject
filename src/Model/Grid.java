package Model;


import Application.Entities;

/**
 * Created by Eliott and Valentin on 14/10/2015.
 */
public class Grid {
    private Cell[][] matrix;    //the matrix represents the grid
    private int rows;   //number of rows in the grid
    private int columns;    //number of columns in the grid

    // -- Grid --------------------------------------
    // Creates a new grid
    // ----------------------------------------------
    public Grid() {
        this.rows = Entities.ROWS_NUMBER;
        this.columns = Entities.COLUMNS_NUMBER;
        this.matrix = new Cell[rows][columns];
        buildGrid();
    }

    // -- buildGrid ---------------------------------
    // Builds the matrix representing the grid
    // ----------------------------------------------
    public void buildGrid() {
        for (int i = 0; i < rows; i++) {    //for each row in the grid
            for (int j = 0; j < columns; j++) {     //and for each column
                matrix[i][j] = new Cell(i, j,   //a cell is created and added to the matrix
                        Entities.ROW_POS_X * i + Entities.COLUMN_POS_X * j + Entities.GRID_POS_X - Entities.WINDOW_WIDTH/10,
                        Entities.COLUMN_POS_Y * j + Entities.ROW_POS_Y * i + Entities.GRID_POS_Y + Entities.WINDOW_HEIGHT/10);
            }
        }
    }

    // -- getMatrix ----------------------------------
    // Returns the matrix representing the grid
    // * out-parameters :
    // - "matrix", Matrix : the matrix representing the grid
    // ----------------------------------------------
    public Cell[][] getMatrix() {
        return matrix;
    }

}
