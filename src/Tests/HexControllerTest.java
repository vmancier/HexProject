package Tests;

import Application.Entities;
import Controller.HexController;
import Model.HexModel;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Eliott and Valentin on 30/11/2015.
 */
public class HexControllerTest {

    @Test
    public void testSwitchPlayer() throws Exception {
        HexModel hm = new HexModel();
        HexController hc = new HexController(hm);
        Assert.assertEquals(HexModel.getPlayer1(), HexModel.getCurrentPlayer());
        hc.switchPlayer();
        Assert.assertEquals(HexModel.getPlayer2(), HexModel.getCurrentPlayer());
        hc.switchPlayer();
        Assert.assertEquals(HexModel.getPlayer1(), HexModel.getCurrentPlayer());
    }

    @Test
    public void testChangeCellColor() throws Exception {
        HexModel hm = new HexModel();
        HexController hc = new HexController(hm);
        for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
            for (int j = 0; j < Entities.COLUMNS_NUMBER; j++) {
                Assert.assertEquals(hm.getGridHex().getMatrix()[i][j].getColor(), Entities.EMPTY_COLOR);
                hc.changeCellColor(i, j);
                Assert.assertEquals(hm.getGridHex().getMatrix()[i][j].getColor(), HexModel.getCurrentPlayer().getColor());
                hc.switchPlayer();
            }
        }
    }
}