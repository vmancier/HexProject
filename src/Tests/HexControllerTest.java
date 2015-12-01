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
        Assert.assertEquals(HexModel.getPlayer1(), HexModel.getCurrentPlayer());
        hcTest.switchPlayer();
        Assert.assertEquals(HexModel.getPlayer2(), HexModel.getCurrentPlayer());
        hcTest.switchPlayer();
        Assert.assertEquals(HexModel.getPlayer1(), HexModel.getCurrentPlayer());
    }

    @Test
    public void testChangeCellColor() throws Exception {
        for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
            for (int j = 0; j < Entities.COLUMNS_NUMBER; j++) {
                Assert.assertEquals(hmTest.getGridHex().getMatrix()[i][j].getColor(), Entities.EMPTY_COLOR);
                hcTest.changeCellColor(i, j);
                Assert.assertEquals(hmTest.getGridHex().getMatrix()[i][j].getColor(), HexModel.getCurrentPlayer().getColor());
                hcTest.switchPlayer();
            }
        }
    }
}