package Model;

import java.awt.*;

/**
 * Created by Eliott on 14/10/2015.
 */
public class Cell {

    private int positionX;
    private int centerX;
    private int centerY;
    private int positionY;
    private Color color;
    Polygon p = new Polygon () ;
    double arc =( Math .PI *2) /6;
    double rad;

    public Cell(int posX, int posY, int centX, int centY) {
        this.positionX = posX;
        this.positionY = posY;
        this.centerX = centX;
        this.centerY = centY;
        this.rad = Math.sqrt(Math.pow(positionX-positionY,2)+Math.pow(centerX-centerY,2));
        this.color = Color.gray;
        for (int i=0; i <=6; i++) {
            this.p. addPoint (( int) Math . round ( centerX +rad* Math .cos(arc*i) ) ,
                    (int) Math . round ( centerY +rad* Math .sin(arc*i) ) ) ;
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
