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
    private JPanel victoryPanel;
    private JButton playB;
    private JButton quitB;
    private JButton nextB;

    // -- HexView -----------------------------------
    // Creates a new view
    // * in-parameters :
    // - "name", String : the title of the window
    // - "model", HexModel : the model linked to the view
    // - "controller", HexController : the controller linked to the view
    // - "posX", int : the horizontal position of the window
    // - "posY", int : the vertical position of the window
    // ----------------------------------------------
    public HexView(String name, HexModel model, HexController controller, int posX, int posY) {
        this.name = name;
        this.model = model;
        this.controller = controller;

        hexFrame = new JFrame(name);    //creating a new window
        hexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //closes the window when clicking an close operation is catched
        hexFrame.setSize(Entities.WINDOW_WIDTH, Entities.WINDOW_HEIGHT);
        hexFrame.setLocation(posX, posY);
        hexFrame.setResizable(false);   //locking the window
        model.addObserver(this);    //the view is now an observer of the model

        menuPanel = createMenuPanel();    //creating first the menu
        hexFrame.add(menuPanel);    //adding it to the frame
        mainPanel = createGamePanel(model);    //the creating the game panel

        mainPanel.addMouseListener(new MouseAdapter() { //adding a mouse listener on the game panel
            @Override
            public void mouseClicked(MouseEvent arg0) { //listening only the clicks
                for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
                    for (int j = 0; j < Entities.COLUMNS_NUMBER; j++) {
                        if (model.getGridHex().getMatrix()[i][j].contains(arg0.getPoint())) {//checking if the click was located in a grid's cell
                            controller.changeCellColor(i, j); //if so, then changing the color of the cell
                            model.groupCells(i, j);
                            if (model.victory()) {
                                victoryPanel = createVictoryPanel();
                                mainPanel.setVisible(false);
                                hexFrame.add(victoryPanel);
                                victoryPanel.setVisible(true);
                            }
                            controller.switchPlayer();  //and switching of player
                        }
                    }
                }
                mainPanel.repaint();    //refreshing the game panel
            }
        });
        hexFrame.setVisible(true);  //finally, making the window visible
    }

    // -- createMenuPanel ---------------------------
    // Creates the menu's panel
    // * out-parameters :
    // - "menuP", JPanel : the menu panel
    // ----------------------------------------------
    public JPanel createMenuPanel() {
        JPanel menuP = new JPanel();    //creating an empty panel
        menuP.setBackground(Entities.PLAYER2_COLOR);
        menuP.setLayout(null);

        JLabel titleL = new JLabel("Hex");
        titleL.setFont(new Font("Verdana", 1, 40));
        titleL.setBounds(Entities.WINDOW_WIDTH / 2 - titleL.getPreferredSize().width / 2, 50, 100, 30);

        JLabel footerL = new JLabel("Created by Valentin Mancier and Eliott Vincent -- IUT de Bordeaux -- December 2015");
        footerL.setFont(new Font("Verdana", 1, 12));
        footerL.setBounds(Entities.WINDOW_WIDTH / 2 - footerL.getPreferredSize().width / 2, Entities.WINDOW_HEIGHT - 55, 600, 30);

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

        menuP.add(titleL);  //adding the created elements to the panel
        menuP.add(footerL);
        menuP.add(playB);
        menuP.add(quitB);
        return menuP;
    }

    // -- actionPerformed ---------------------------
    // Waits for events on the menu's buttons
    // * in-parameters :
    // - "e", ActionEvent : the event
    // ----------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == playB) {
            menuPanel.setVisible(false);
            hexFrame.add(mainPanel);
            mainPanel.setVisible(true);
        } else if (source == quitB) {
            System.exit(1);
        } else if (source == nextB) {
            victoryPanel.setVisible(false);
            model.initModel();
            hexFrame.add(menuPanel);
            menuPanel.setVisible(true);
        }
    }

    // -- createGamePanel ---------------------------
    // Creates the game's panel
    // * in-parameters :
    // - "m", HexModel : the game's model
    // * out-parameters :
    // - "gameP", JPanel : the game's panel
    // ----------------------------------------------
    public JPanel createGamePanel(HexModel m) {
        JPanel gameP = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) { //overriding the paintComponent() function
                paintComponent((Graphics2D) g); //we can now use Graphics2D
            }

            protected void paintComponent(Graphics2D g) {
                super.paintComponent(g);
                createGrid(g, m);
                createBorders(g);
            }
        };
        return gameP;
    }

    // -- createGrid --------------------------------
    // Creates the game's grid
    // * in-parameters :
    // - "g", Graphics2D : the graphics
    // - "m", HexModel : the game's model
    // ----------------------------------------------
    public void createGrid(Graphics2D g, HexModel m) {
        Grid tmpGrid = m.getGridHex();  //creating a new grid from the hex's grid
        Cell[][] tmpMatrix = tmpGrid.getMatrix();   //creating a new matrix from the new grid
        for (int i = 0; i < Entities.ROWS_NUMBER; i++) {
            for (int j = 0; j < Entities.COLUMNS_NUMBER; j++) {
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g.setColor(Color.black);    //borders
                g.drawPolygon(tmpMatrix[i][j]);
                g.setColor(tmpMatrix[i][j].getColor());   //filling color
                g.fillPolygon(tmpMatrix[i][j]);
            }
        }
    }

    // -- createBorders -----------------------------
    // Creates the external colored borders of the grid
    // * in-parameters :
    // - "g", Graphics2D : the graphics
    // ----------------------------------------------
    protected void createBorders(Graphics2D g) {
        g.setColor(Entities.PLAYER1_COLOR);
        g.setStroke(new BasicStroke(2));
        int top1 = 0;
        int top2 = 0;
        for (int i = 0; i < 7; i++) {
            g.drawLine(381 + top1, 77 + top2, 410 + top1, 77 + top2);   //right up blue borders
            g.drawLine(411 + top1, 78 + top2, 426 + top1, 103 + top2);
            g.drawLine(411 - top1, 442 - top2, 381 - top1, 442 - top2); //left down blue borders
            g.drawLine(380 - top1, 441 - top2, 365 - top1, 416 - top2);
            top1 += 46;
            top2 += 26;
        }
        top1 = 0;
        top2 = 0;
        g.setColor(Entities.PLAYER2_COLOR);
        for (int i = 0; i < 7; i++) {
            g.drawLine(702 - top1, 260 + top2, 688 - top1, 285 + top2); //right down pink borders
            g.drawLine(687 - top1, 286 + top2, 657 - top1, 286 + top2);
            g.drawLine(89 + top1, 259 - top2, 103 + top1, 234 - top2);   //left up pink borders
            g.drawLine(104 + top1, 233 - top2, 134 + top1, 233 - top2);
            top1 += 46;
            top2 += 26;
        }
    }

    // -- update -----------------------------------
    // Called whenever the observed object is changed
    // * in-parameters :
    // - "o", Observable : the observable object
    // - "arg", Object : an argument passed to the notifyObservers method
    // ---------------------------------------------
    @Override   //needs to be override since HewView implements Observe
    public void update(Observable o, Object arg) {

    }

    // -- createVictoryPanel ------------------------
    // Creates the victory's panel
    // * out-parameters :
    // - "victoryP", JPanel : the menu panel
    // ----------------------------------------------
    public JPanel createVictoryPanel() {
        JPanel victoryP = new JPanel();

        victoryP.setBackground(Entities.PLAYER2_COLOR);
        victoryP.setLayout(null);

        JLabel titleL1 = new JLabel("Victoire du " + model.getCurrentPlayer().toString());
        titleL1.setFont(new Font("Verdana", 1, 40));
        titleL1.setBounds(Entities.WINDOW_WIDTH / 2 - titleL1.getPreferredSize().width / 2, 100, 500, 50);

        nextB = new JButton("Next");
        nextB.setBounds(Entities.WINDOW_WIDTH / 2 - nextB.getPreferredSize().width / 2, Entities.WINDOW_HEIGHT / 2, 100, 30);
        nextB.setBorder(BorderFactory.createEmptyBorder());
        nextB.setFocusPainted(false);
        nextB.setBackground(Entities.PLAYER1_COLOR);
        nextB.addActionListener(this);

        victoryP.add(titleL1);
        victoryP.add(nextB);

        return victoryP;
    }
}