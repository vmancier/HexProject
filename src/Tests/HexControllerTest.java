package Tests;

import Application.Entities;
import Controller.HexController;
import Model.HexModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Eliott and Valentin on 30/11/2015.
 */
public class HexControllerTest {

    HexModel hmTest;
    HexController hcTest;

    @Before
    public void setUp() {
        hmTest = new HexModel();
        hcTest = new HexController(hmTest);
    }

    @Test
    public void testSwitchPlayer() throws Exception {
        Assert.assertEquals(hmTest.getPlayer1(), hmTest.getCurrentPlayer());
        hcTest.switchPlayer();
        Assert.assertEquals(hmTest.getPlayer2(), hmTest.getCurrentPlayer());
        hcTest.switchPlayer();
        Assert.assertEquals(hmTest.getPlayer1(), hmTest.getCurrentPlayer());
    }

    @Test
    public void testChangeCellColor() throws Exception {
        for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
            for (int j = 0; j < Entities.COLUMNS_NUMBER; j++) {
                Assert.assertEquals(Entities.EMPTY_COLOR, hmTest.getGridHex().getMatrix()[i][j].getColor());
                hcTest.changeCellColor(i, j);
                Assert.assertEquals(hmTest.getCurrentPlayer().getColor(), hmTest.getGridHex().getMatrix()[i][j].getColor());
                hcTest.switchPlayer();
            }
        }
    }
}