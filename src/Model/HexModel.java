package Model;

/**
 * Created by Valentin on 14/10/2015.
 */
import java.awt.*;
import java.util.Observable;

public class HexModel extends Observable {
    Grid gridHex;

    public HexModel(){
        gridHex = new Grid(5,5);
    }

    public void displayHex(Graphics g) {
        gridHex.displayGrid(g);
    }

}