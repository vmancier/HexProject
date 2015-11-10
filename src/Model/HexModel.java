package Model;

/**
 * Created by Valentin on 14/10/2015.
 */
import Application.Entities;

import java.awt.*;
import java.util.Observable;

public class HexModel extends Observable {
    Grid gridHex;

    public HexModel(){
        gridHex = new Grid();
    }

    public Grid getGridHex() {
        return gridHex;
    }

    public boolean playerWin(){
        boolean win = false;
        for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
            if (victory(gridHex.getMatrix()[i][0], Color.BLACK)){
                win = true;
            }
        }
        return win;
    }

    public boolean victory(Cell c, Color color){
        if (c.getPosX()==Entities.ROWS_NUMBER){
            return true;
        }
        else if(c.getColor()== color){
            return victory(c, color);
        }
        else{
            return false;
        }
    }
}