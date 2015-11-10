package Model;

import Application.Entities;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Eliott on 14/10/2015.
 */
public class Cell extends Polygon {

    private int centerX;
    private int centerY;
    private Color color;
    double arc =( Math .PI *2)/6;
    double rad;


    public Cell(int centX, int centY) {
        this.centerX = centX;
        this.centerY = centY;
        this.rad = Entities.CELL_SIZE;
        this.color = Entities.EMPTY_COLOR;


        for (int i=0; i <=6; i++) {
            this.addPoint((int) Math.round(centerX + rad * Math.cos(arc * i)),
                    (int) Math.round(centerY + rad * Math.sin(arc * i))) ;
        }
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
