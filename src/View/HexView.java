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

import static Model.Cell.*;

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

        JPanel pa = displayPanel(model);
        pa.setLayout(null);
        pa.setBounds(0, 0, 200, 300);
        hexFrame.add(pa);
        hexFrame.setSize(Entities.WINDOW_WIDTH, Entities.WINDOW_HEIGHT);
        hexFrame.setLocation(posX, posY);
        hexFrame.setVisible(true);
    }

    public JPanel displayPanel(HexModel m) {
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                paintComponent((Graphics2D) g);
            }
            protected void paintComponent(Graphics2D g){
                super.paintComponent(g);
                displayGrid(g, m);
            }
        };
        return p;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public void displayGrid(Graphics2D g, HexModel m) {
        Grid tmpGrid = m.getGridHex();
        Cell[][] tmpMatrix = tmpGrid.getMatrix();
        for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
            for (int j = 0; j < Entities.COLUMNS_NUMBER; j++) {
                g.setColor(Color.black);    //borders
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g.drawPolygon(tmpMatrix[i][j]);
                g.setColor(getColor());   //filling color
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g.fillPolygon(tmpMatrix[i][j]);

            }
        }
    }
}