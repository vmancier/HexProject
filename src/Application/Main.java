package Application;

import Controller.*;
import Model.*;
import View.*;

/**
 * Created by Valentin on 14/10/2015.
 */
public class Main {
    public Main() {
        HexModel hm = new HexModel();
        HexController hc = new HexController(hm);
        HexView hv = new HexView("Hex Project", hm, hc, 200, 200);
        hc.addView(hv);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}