package View;

/**
 * Created by Valentin on 14/10/2015.
 */
import java.util.Observable;
import java.util.Observer;
import java.awt.*;
import javax.swing.*;
import Model.*;
import Controller.*;

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
        hexFrame.add(new JLabel(name), BorderLayout.NORTH);
        //hexFrame.add(displayField, BorderLayout.CENTER);
        hexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model.addObserver(this);
        hexFrame.pack(); //hexFrame.setSize(200, 100);
        hexFrame.setLocation(posX, posY);
        hexFrame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}