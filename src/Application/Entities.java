package Application;

import java.awt.*;

/**
 * Created by Eliott on 19/10/2015.
 */
public class Entities {
    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SCREEN_HEIGHT = (int) SCREEN_SIZE.getHeight();
    public static final int SCREEN_WIDTH = (int) SCREEN_SIZE.getWidth();

    public static final int WINDOW_HEIGHT = 600;
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_POSX = SCREEN_WIDTH / 2 - WINDOW_WIDTH / 2;
    public static final int WINDOW_POSY = SCREEN_HEIGHT / 2 - WINDOW_HEIGHT / 2;

    public static final int ROWS_NUMBER = 7;
    public static final int COLUMNS_NUMBER = 7;

    public static final Color EMPTY_COLOR = Color.lightGray;
    public static final Color PLAYER1_COLOR = new Color(125, 198, 236);
    public static final Color PLAYER2_COLOR = new Color(250, 184, 186);

    public static final int GRID_POS_X = WINDOW_WIDTH / 2 - 200;
    public static final int GRID_POS_Y = WINDOW_HEIGHT / 2 - 100;

    public static final int COLUMN_POS_X = 31;
    public static final int COLUMN_POS_Y = 18;
    public static final int ROW_POS_X = 31;
    public static final int ROW_POS_Y = -17;

    public static final int CELL_SIZE = 20;
}
