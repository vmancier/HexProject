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

    public void switchPlayer() {
        if (HexModel.getCurrentPlayer() == HexModel.getPlayer1()) {
            HexModel.getPlayer1().setIsPlaying(false);
            HexModel.setCurrentPlayer(HexModel.getPlayer2());
            HexModel.getPlayer2().setIsPlaying(true);
        }
        else {
            HexModel.getPlayer2().setIsPlaying(false);
            HexModel.setCurrentPlayer((HexModel.getPlayer1()));
            HexModel.getPlayer1().setIsPlaying(true);
        }
    }
}
