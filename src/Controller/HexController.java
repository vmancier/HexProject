package Controller;

import Application.Entities;
import Model.*;
import View.*;

import java.awt.*;

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
        } else {
            HexModel.getPlayer2().setIsPlaying(false);
            HexModel.setCurrentPlayer((HexModel.getPlayer1()));
            HexModel.getPlayer1().setIsPlaying(true);
        }
    }

    public void changeCellColor(int i, int j){
        //if (model.getGridHex().getMatrix()[i][j].getColor()== Entities.EMPTY_COLOR)
        //{
            model.getGridHex().getMatrix()[i][j].setColor(Entities.PLAYER1_COLOR);//model.getCurrentPlayer().getColor());
        //}
    }
}
