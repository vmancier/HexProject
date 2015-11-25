package Model;


import Application.Entities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
                matrix[i][j] = new Cell(i,j,Entities.ROW_POS_X *i + Entities.COLUMN_POS_X*j + Entities.GRID_POS_X ,
                        Entities.COLUMN_POS_Y*j + Entities.ROW_POS_Y*i + Entities.GRID_POS_Y);
            }
        }
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public Cell getCell(int i , int j){return matrix[i][j];}
}
