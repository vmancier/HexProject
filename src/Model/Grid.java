package Model;

/**
 * Created by Eliott on 14/10/2015.
 */
public class Grid {
    private Cell[][] matrix;

    public Grid() {
        this.matrix = new Cell[7][7];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Cell(i, j, i, j);
                System.out.println(matrix[i][j]);
            }
        }
    }
}
