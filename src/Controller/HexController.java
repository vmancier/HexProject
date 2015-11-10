package Controller;

import Application.Entities;
import Model.*;
import View.*;

/**
 * Created by Valentin on 14/10/2015.
 */
public class HexController {
    private HexModel model;
    private HexView view = null;

    public HexController(HexModel m){
        model = m;
    }

    public void addView(HexView view)
    {
        this.view = view;
    }

    public void changeCellColor(int i, int j){
        if (model.getGridHex().getMatrix()[i][j].getColor()== Entities.EMPTY_COLOR)
        {
            //model.getGridHex().getMatrix()[i][j].setColor(model.getCurrentPlayer().getColor());
        }
    }
}
