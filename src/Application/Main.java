package Application;

import Controller.HexController;
import Model.HexModel;
import View.HexView;

/**
 * Created by Valentin and Eliott on 14/10/2015.
 */
public class Main {

    // -- Main --------------------------------------
    // Creates the GUI application
    // ----------------------------------------------
    public Main() {
        HexModel hm = new HexModel();   //creates a new model
        HexController hc = new HexController(hm);   //creates a new controller
        HexView hv = new HexView("Hex Project", hm, hc, Entities.WINDOW_POSX, Entities.WINDOW_POSY);    //creates e new view
        hc.addView(hv); //links the view to the model
    }

    // -- main --------------------------------------
    // Launches the GUI creation task
    // ----------------------------------------------
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() { //all the modifications will be done by the same thread
            public void run() {
                new Main();
            }
        });
    }
}