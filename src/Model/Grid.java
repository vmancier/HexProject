package Model;

/**
 * Created by Eliott on 14/10/2015.
 */
public class Grid {
    private Cell[][] matrix;
    private int rows;
    private int columns;

    public Grid(int rows,int columns) {
        this.rows =rows;
        this.columns =columns;
        this.matrix = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = new Cell(i, j, i, j);
                System.out.println(matrix[i][j]);
            }
        }
    }
}
