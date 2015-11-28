package Controller;

import Application.Entities;
import Model.HexModel;
import View.HexView;

/**
 * Created by Valentin and Eliott on 14/10/2015.
 */
public class HexController {
    private HexModel model;
    private HexView view = null;

    // -- HexController -----------------------------
    // Creates a new controller
    // * in-parameters :
    // - "m", HexModel : the model to be added
    // ----------------------------------------------
    public HexController(HexModel m) {
        model = m;
    }

    // -- addView -----------------------------------
    // Adds a view to the controller
    // * in-parameters :
    // - "view", HexView : the view to be added
    // ----------------------------------------------
    public void addView(HexView view) {
        this.view = view;
    }

    // -- switchPlayer ---------------------------
    // Switches the current player
    // ----------------------------------------------
    public static void switchPlayer() {
        if (HexModel.getCurrentPlayer() == HexModel.getPlayer1()) { //if the player 1 is the one currently playing
            HexModel.getPlayer1().setIsPlaying(false);
            HexModel.setCurrentPlayer(HexModel.getPlayer2());   //then switch to player 2
            HexModel.getPlayer2().setIsPlaying(true);
        } else {    //else means that the player 2 is the one currently playing
            HexModel.getPlayer2().setIsPlaying(false);
            HexModel.setCurrentPlayer((HexModel.getPlayer1())); //then switch to player 1
            HexModel.getPlayer1().setIsPlaying(true);
        }
    }

    // -- changeCellColor ---------------------------
    // Changes the color of a cell
    // * in-parameters :
    // - "i", int : the "i" position of the cell in the matrix
    // - "j", int : the "j" position of the cell in the matrix
    // ----------------------------------------------
    public void changeCellColor(int i, int j) {
        if (model.getGridHex().getMatrix()[i][j].getColor() == Entities.EMPTY_COLOR) {  //if the clicked cell is empty
            model.getGridHex().getMatrix()[i][j].setColor(model.getCurrentPlayer().getColor()); //then change its color to the current player's color
        }
    }
}
