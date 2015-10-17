package Model;

import java.awt.*;

/**
 * Created by Eliott on 14/10/2015.
 */
public class Cell {

    private int positionX;
    private int positionY;
    private int centerX;
    private int centerY;
    private Color color;

    public Cell(int posX, int posY, int centX, int centY) {
        this.positionX = posX;
        this.positionY = posY;
        this.centerX = centX;
        this.centerY = centY;
        this.color = Color.gray;
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

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
