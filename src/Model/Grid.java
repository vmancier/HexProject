package Model;


import Application.Entities;

/**
 * Created by Eliott on 14/10/2015.
 */
public class Grid {
    private Cell[][] matrix;
    private int rows;
    private int columns;

    public Grid() {
        this.rows = Entities.ROWS_NUMBER;
        this.columns = Entities.COLUMNS_NUMBER;
        this.matrix = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = new Cell(31*i + 25 , 35*j+ 17 *i +25);
                //System.out.println(matrix[i][j]);
            }
        }
    }

    public Cell[][] getMatrix() {
        return matrix;
    }
}
