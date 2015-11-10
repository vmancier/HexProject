package Model;

import Application.Entities;

import java.awt.*;

/**
 * Created by Eliott on 14/10/2015.
 */
public class Cell extends Polygon {

    private float positionX;
    private float positionY;
    private int centerX;
    private int centerY;
    private Color color;
    double arc =( Math .PI *2)/6;
    double rad;


    public Cell(float posX, float posY, int centX, int centY) {
        this.positionX = posX;
        this.positionY = posY;
        this.centerX = centX;
        this.centerY = centY;
        this.rad = 20;//Math.sqrt(Math.pow(positionX-positionY,2)+Math.pow(centerX-centerY,2));
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

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
