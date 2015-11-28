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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;


public class HexView implements Observer, ActionListener {
    protected HexModel model;
    protected HexController controller;
    private String name;
    private JFrame hexFrame;
    private JPanel menuPanel;
    private JPanel mainPanel;
    private JButton playB;
    private JButton quitB;

    public HexView(String name, HexModel model, HexController controller, int posX, int posY) {
        this.name = name;
        this.model = model;
        this.controller = controller;

        hexFrame = new JFrame(name);
        hexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hexFrame.setSize(Entities.WINDOW_WIDTH, Entities.WINDOW_WIDTH);
        hexFrame.setLocation(posX, posY);
        hexFrame.setResizable(false);
        model.addObserver(this);

        menuPanel = displayMenuPanel(model);
        hexFrame.add(menuPanel);
        mainPanel = displayMainPanel(model);

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
                    for (int j = 0; j < Entities.COLUMNS_NUMBER; j++) {
                        if (model.getGridHex().getMatrix()[i][j].contains(arg0.getPoint())) {
                            controller.changeCellColor(i, j);
                            controller.switchPlayer();
                        }
                    }
                }
                mainPanel.repaint();
            }
        });// Evenement qui survient au click
        hexFrame.setVisible(true);
    }

    public JPanel displayMenuPanel(HexModel m) {
        JPanel menuP = new JPanel();
        menuP.setBackground(Entities.PLAYER2_COLOR);
        menuP.setLayout(null);

        JLabel titleL = new JLabel("Hex");
        titleL.setFont(new Font("Verdana", 1, 40));
        titleL.setBounds(Entities.WINDOW_WIDTH / 2 - 100 / 2, 50, 100, 30);

        JLabel footerL = new JLabel("Created by Valentin Mancier and Eliott Vincent -- IUT de Bordeaux -- December 2015");
        footerL.setFont(new Font("Verdana", 1, 12));
        footerL.setBounds(0, Entities.WINDOW_HEIGHT - 55, 600, 30);

        playB = new JButton("Play");
        playB.setBounds(Entities.WINDOW_WIDTH / 2 - 100 / 2, Entities.WINDOW_HEIGHT / 2, 100, 30);
        playB.setBorder(BorderFactory.createEmptyBorder());
        playB.setFocusPainted(false);
        playB.setBackground(Entities.PLAYER1_COLOR);
        playB.addActionListener(this);

        quitB = new JButton("Quit");
        quitB.setBounds(Entities.WINDOW_WIDTH / 2 - 100 / 2, Entities.WINDOW_HEIGHT / 2 + 30 * 2, 100, 30);
        quitB.setBorder(BorderFactory.createEmptyBorder());
        quitB.setBackground(Entities.PLAYER1_COLOR);
        quitB.addActionListener(this);

        menuP.add(titleL);
        menuP.add(footerL);
        menuP.add(playB);
        menuP.add(quitB);
        return menuP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == playB) {
            menuPanel.setVisible(false);
            hexFrame.add(mainPanel);
            mainPanel.setVisible(true);
        } else if (source == quitB) {
            System.exit(1);
        }
    }

    public JPanel displayMainPanel(HexModel m) {
        JPanel mainP = new JPanel() {
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
        return mainP;
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

    protected void displayBorders(Graphics2D g) {
        g.setColor(Entities.PLAYER1_COLOR);
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
        g.setColor(Entities.PLAYER2_COLOR);
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