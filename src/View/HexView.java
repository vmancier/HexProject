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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;


public class HexView implements Observer {
    protected HexModel model;
    protected HexController controller;
    private String name;
    private JFrame hexFrame;
    private JPanel mainPanel;
    private JPanel[][] gridPanel;

    public HexView(String name, HexModel model, HexController controller, int posX, int posY) {
        this.name = name;
        this.model = model;
        this.controller = controller;

        this.gridPanel = new JPanel[Entities.ROWS_NUMBER][Entities.COLUMNS_NUMBER];
        hexFrame = new JFrame(name);
        hexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hexFrame.setSize(500, 500);
        hexFrame.setLocation(posX, posY);
        model.addObserver(this);

        hexFrame.setSize(Entities.WINDOW_WIDTH, Entities.WINDOW_WIDTH);
        hexFrame.setLocation(posX, posY);

        mainPanel = displayMainPanel(model);
        hexFrame.add(mainPanel);

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
                    for (int j = 0; j < Entities.COLUMNS_NUMBER; j++) {
                        if (model.getGridHex().getMatrix()[i][j].contains(arg0.getPoint())) {
                            controller.changeCellColor(i,j);
                        }
                    }
                }
                mainPanel.repaint();
            }
        });// Evenement qui survient au click

        hexFrame.setVisible(true);
    }

    public JPanel displayMainPanel(HexModel m) {
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                paintComponent((Graphics2D) g);

            }

            protected void paintComponent(Graphics2D g) {
                super.paintComponent(g);
                displayGrid(g, m);
                displayLines(g);
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
                g.setColor(tmpMatrix[i][j].getColor());   //filling color
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g.fillPolygon(tmpMatrix[i][j]);
            }
        }
    }

    protected void displayLines(Graphics2D g) {
        int x1 = 300;
        int y1 = 80;
        int x2 = 480;
        int y2 = 185;
        int x3 = 480;
        int y3 = 225;
        int x4 = 300;
        int y4 = 325;
        int x5 = 270;
        int y5 = 325;
        int x6 = 90;
        int y6 = 220;
        int x7 = 90;
        int y7 = 180;
        int x8 = 270;
        int y8 = 80;

        g.setColor(Color.blue);
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x5, y5, x6, y6);
        g.setColor(Color.red);
        g.drawLine(x3, y3, x4, y4);
        g.drawLine(x7, y7, x8, y8);

    }

}