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
    private JPanel pa;
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
                /*for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
                    for (int j = 0; j < Entities.COLUMNS_NUMBER; j++) {
                        //if (//model.getGridHex().getMatrix()[i][j].getCenterX()-Entities.CELL_SIZE>=arg0.getX() &&
                        // model.getGridHex().getMatrix()[i][j].getCenterX()<=arg0.getX()){
                        //model.getGridHex().getMatrix()[i][j].getPosX()<=arg0.getX()+Entities.CELL_SIZE) {
                        //controller.changeCellColor(i,j);
                        if (model.getGridHex().getMatrix()[i][j].contains(arg0.getPoint())) {
                            //).getMatrix()[i][j].getCenterX());
                            controller.changeCellColor(i, j);
                            pa.repaint();
                        }
                    }
                }*/

                for (int i = 0; i <  Entities.ROWS_NUMBER; i++) {

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
                displayBorders(g);
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

    public void refresh() {
        pa = displayPanel(model);
    }

    protected void displayBorders(Graphics2D g) {

        g.setColor(Color.blue);
        g.setStroke(new BasicStroke(2));
        int top1 = 0;
        int top2 = 0;
        for (int i = 0; i < 7; i++) {
            g.drawLine(276 + top1, 80 + top2, 295 + top1, 80 + top2);   //right up blue borders
            g.drawLine(295 + top1, 80 + top2, 305 + top1, 97 + top2);
            g.drawLine(295 - top1, 325 - top2, 275 - top1, 325 - top2); //left down blue borders
            g.drawLine(274 - top1, 324 - top2, 266 - top1, 307 - top2);
            top1 += 31;
            top2 += 18;
        }
        top1 = 0;
        top2 = 0;
        g.setColor(Color.red);
        for (int i = 0; i < 7; i++) {
            g.drawLine(492 - top1, 206 + top2, 483 - top1, 222 + top2); //right down red borders
            g.drawLine(482 - top1, 223 + top2, 461 - top1, 223 + top2);
            g.drawLine(80 + top1, 198 - top2, 88 + top1, 183 - top2);   //left up red borders
            g.drawLine(275 - top1, 80 + top2, 295 - top1, 80 + top2);
            top1 += 31;
            top2 += 17;
        }
    }

}