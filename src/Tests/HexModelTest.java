package Tests;

import Controller.HexController;
import Model.HexModel;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Eliott on 01/12/2015.
 */
public class HexModelTest {

    @Test
    public void testGroupCells() throws Exception {
        HexModel hm = new HexModel();   //creates a new model
        HexController hc = new HexController(hm);
    }

    @Test
    public void testNbNextToCell() throws Exception {

    }

    @Test
    public void testVictory() throws Exception {

    }
}