package Model;

/**
 * Created by Valentin on 14/10/2015.
 */
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

}