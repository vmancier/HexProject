package Tests;

import Application.Entities;
import Controller.HexController;
import Model.Cell;
import Model.HexModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.util.ArrayList;

/**
 * Created by Eliott on 01/12/2015.
 */
public class HexModelTest {

    HexModel hmTest;
    HexController hcTest;

    @Before
    public void setUp() {
        hmTest = new HexModel();
        hcTest = new HexController(hmTest);
    }

    @Test
    public void testGroupCells() throws Exception {
        hmTest.initModel();
        ArrayList<Cell> cells = new ArrayList<Cell>();

        System.out.print(hmTest.getCurrentPlayer().getBlocks().size());

        hcTest.changeCellColor(3, 3);
        cells.add(hmTest.getGridHex().getMatrix()[3][3]);
        hmTest.groupCells(3, 3);
        Assert.assertEquals(1, hmTest.getCurrentPlayer().getBlocks().size());

        cells.add(hmTest.getGridHex().getMatrix()[4][2]);
        hmTest.groupCells(4, 2);
        Assert.assertEquals(1, hmTest.getCurrentPlayer().getBlocks().size());

        cells.add(hmTest.getGridHex().getMatrix()[4][3]);
        hmTest.groupCells(4, 3);
        Assert.assertEquals(1, hmTest.getCurrentPlayer().getBlocks().size());

        cells.add(hmTest.getGridHex().getMatrix()[3][4]);
        hmTest.groupCells(3, 4);
        Assert.assertEquals(1, hmTest.getCurrentPlayer().getBlocks().size());

        cells.add(hmTest.getGridHex().getMatrix()[2][4]);
        hmTest.groupCells(2, 4);
        Assert.assertEquals(1, hmTest.getCurrentPlayer().getBlocks().size());

        cells.add(hmTest.getGridHex().getMatrix()[2][3]);
        hmTest.groupCells(2, 3);
        Assert.assertEquals(1, hmTest.getCurrentPlayer().getBlocks().size());

        cells.add(hmTest.getGridHex().getMatrix()[3][2]);
        hmTest.groupCells(3, 2);
        Assert.assertEquals(1, hmTest.getCurrentPlayer().getBlocks().size());
    }

    @Test
    public void testNbNextToCell() throws Exception {
        hmTest.initModel();
        ArrayList<Cell> cells = new ArrayList<Cell>();

        hcTest.changeCellColor(3, 3);
        cells.add(hmTest.getGridHex().getMatrix()[3][3]);
        hmTest.getCurrentPlayer().getBlocks().add(cells);
        int test = hmTest.nbNextToCell(hmTest.getGridHex().getMatrix()[3][3]);
        Assert.assertEquals(0, hmTest.nbNextToCell(hmTest.getGridHex().getMatrix()[3][3]));

        cells.add(hmTest.getGridHex().getMatrix()[4][2]);
        hmTest.getCurrentPlayer().getBlocks().add(cells);
        Assert.assertEquals(1, hmTest.nbNextToCell(hmTest.getGridHex().getMatrix()[3][3]));

        cells.add(hmTest.getGridHex().getMatrix()[4][3]);
        hmTest.getCurrentPlayer().getBlocks().add(cells);
        Assert.assertEquals(2, hmTest.nbNextToCell(hmTest.getGridHex().getMatrix()[3][3]));

        cells.add(hmTest.getGridHex().getMatrix()[3][4]);
        hmTest.getCurrentPlayer().getBlocks().add(cells);
        Assert.assertEquals(3, hmTest.nbNextToCell(hmTest.getGridHex().getMatrix()[3][3]));

        cells.add(hmTest.getGridHex().getMatrix()[2][4]);
        hmTest.getCurrentPlayer().getBlocks().add(cells);
        Assert.assertEquals(4, hmTest.nbNextToCell(hmTest.getGridHex().getMatrix()[3][3]));

        cells.add(hmTest.getGridHex().getMatrix()[2][3]);
        hmTest.getCurrentPlayer().getBlocks().add(cells);
        Assert.assertEquals(5, hmTest.nbNextToCell(hmTest.getGridHex().getMatrix()[3][3]));

        cells.add(hmTest.getGridHex().getMatrix()[3][2]);
        hmTest.getCurrentPlayer().getBlocks().add(cells);
        Assert.assertEquals(6, hmTest.nbNextToCell(hmTest.getGridHex().getMatrix()[3][3]));
    }

    @Test
    public void testVictory() throws Exception {
        hmTest.initModel();
        for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
            hcTest.changeCellColor(i, 3);
            hmTest.groupCells(i, 3);
        }
        Assert.assertEquals(true, hmTest.victory());

        hmTest.initModel();
        for (int i = 0; i < Entities.ROWS_NUMBER-1; i++) {
            hcTest.changeCellColor(i, 3);
            hmTest.groupCells(i, 3);
        }
        Assert.assertNotEquals(true, hmTest.victory());
    }
}