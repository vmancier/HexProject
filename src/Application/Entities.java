package Application;

import java.awt.*;

/**
 * Created by Eliott and Valentin on 19/10/2015.
 */
public class Entities {
    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();    //this will get the dimensions of the screen
    public static final int SCREEN_HEIGHT = (int) SCREEN_SIZE.getHeight();
    public static final int SCREEN_WIDTH = (int) SCREEN_SIZE.getWidth();

    public static final int WINDOW_HEIGHT = 600;    //default window height
    public static final int WINDOW_WIDTH = 600;     //default window width
    public static final int WINDOW_POSX = SCREEN_WIDTH / 2 - WINDOW_WIDTH / 2;  //the window will be horizontally centered
    public static final int WINDOW_POSY = SCREEN_HEIGHT / 2 - WINDOW_HEIGHT / 2;    //the window will be vertically centered

    public static final int ROWS_NUMBER = 7;    //number of rows in the game grid
    public static final int COLUMNS_NUMBER = 7; //number of columns in the game grid

    public static final Color EMPTY_COLOR = Color.lightGray;    //default empty color
    public static final Color PLAYER1_COLOR = new Color(125, 198, 236); //default color for first player and also for the menu's buttons
    public static final Color PLAYER2_COLOR = new Color(250, 184, 186); //default color for second player and also for menu background

    public static final int GRID_POS_X = WINDOW_WIDTH / 2 - 200;    //the grid will be horizontally centered in the window
    public static final int GRID_POS_Y = WINDOW_HEIGHT / 2 - 100;   //sets the vertical position for the grid in the window

    public static final int COLUMN_POS_X = 31;  //horizontal position of the columns in the grid
    public static final int COLUMN_POS_Y = 18;  //vertical position of the columns in the grid
    public static final int ROW_POS_X = 31; //horizontal position of the rows in the grid
    public static final int ROW_POS_Y = -17;    //vertical position of the rows in the grid

    public static final int CELL_SIZE = 20; //default cell size
}
