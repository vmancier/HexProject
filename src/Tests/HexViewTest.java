package Tests;

import Application.Entities;
import Controller.HexController;
import Model.HexModel;
import View.HexView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Eliott and Valentin on 30/11/2015.
 */
public class HexViewTest {

    HexModel hmTest;
    HexController hcTest;
    HexView hvTest;

    @Before
    public void setUp() {
        hmTest = new HexModel();
        hcTest = new HexController(hmTest);
        hvTest = new HexView("Test View", hmTest, hcTest, Entities.WINDOW_POSX, Entities.WINDOW_POSY);
        hcTest.addView(hvTest);
    }

    @Test
    public void testCreateMenuPanel() throws Exception {
        Assert.assertNotNull(hvTest.createMenuPanel());
    }

    @Test
    public void testCreateGamePanel() throws Exception {
        Assert.assertNotNull(hvTest.createGamePanel(hmTest));
    }
}