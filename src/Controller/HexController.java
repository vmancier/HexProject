package Controller;

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
}
