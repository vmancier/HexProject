package Model;


import Application.Entities;
import java.awt.*;

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
                matrix[i][j] = new Cell(50*i+10, 50*j, 50*i+50, 50*j+50);

                //System.out.println(matrix[i][j]);
            }
        }
    }

    public Cell[][] getMatrix() {
        return matrix;
    }
}
