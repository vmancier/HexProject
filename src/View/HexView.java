package View;

/**
 * Created by Valentin on 14/10/2015.
 */

import Application.Entities;
import Controller.HexController;
import Model.Cell;
import Model.Grid;
import Model.HexModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class HexView implements Observer {
    private String name;
    protected HexModel model;
    protected HexController controller;
    private JFrame hexFrame;
    //private JTextField displayField = new JTextField();

    public HexView(String name, HexModel model, HexController controller, int posX, int posY) {
        this.name = name;
        this.model = model;
        this.controller = controller;
        hexFrame = new JFrame(name);

        hexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model.addObserver(this);

        hexFrame.add(displayPanel(model));

        hexFrame.setSize(Entities.WINDOW_WIDTH, Entities.WINDOW_WIDTH);
        hexFrame.setLocation(posX, posY);
        hexFrame.setVisible(true);


    }

    public JPanel displayPanel(HexModel m) {
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                displayGrid(g, m);
            }
        };
        return p;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public void displayGrid(Graphics g, HexModel m) {
        Grid tmpGrid = m.getGridHex();
        Cell[][] tmpMatrix = tmpGrid.getMatrix();
        for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
            for (int j = 0; j < Entities.COLUMNS_NUMBER; j++) {
                g.fillPolygon(tmpMatrix[i][j]);
            }
        }
    }
}