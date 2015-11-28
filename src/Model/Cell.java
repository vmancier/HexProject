package Model;

import Application.Entities;

import java.awt.*;

/**
 * Created by Eliott on 14/10/2015.
 */
public class Cell extends Polygon {
    private int posX;   //horizontal position of the cell
    private int posY;   //vertical position of the cell
    private int centerX;    //horizontal position of the cell's center
    private int centerY;    //vertical position of the cell's center
    private Color color;    //color of the cell
    double arc = (Math.PI * 2) / 6; //
    double rad; //

    // -- Cell --------------------------------------
    // Creates a new cell
    // * in-parameters :
    // - "posX", int : the horizontal position of the cell
    // - "posY", int : the vertical position of the cell
    // - "centX", int : the horizontal position of the cell's center
    // - "centY", int : the vertical position of the cell's center
    // ----------------------------------------------
    public Cell(int posX, int posY, int centX, int centY) {
        this.posX = posX;
        this.posY = posY;
        this.centerX = centX;
        this.centerY = centY;
        this.rad = Entities.CELL_SIZE;
        this.color = Entities.EMPTY_COLOR;

        for (int i = 0; i <= 6; i++) {  //creates each side of the polygon
            this.addPoint((int) Math.round(centerX + rad * Math.cos(arc * i)),
                    (int) Math.round(centerY + rad * Math.sin(arc * i)));
        }
    }

    // -- getPosX------------------------------------
    // Returns the horizontal position of the cell
    // * out-parameters :
    // - "posX", int : the horizontal position of the cell
    // ----------------------------------------------
    public int getPosX() {
        return posX;
    }

    // -- getPosY------------------------------------
    // Returns the vertical position of the cell
    // * out-parameters :
    // - "posY", int : the vertical position of the cell
    // ----------------------------------------------
    public int getPosY() {
        return posY;
    }

    // -- getCenterX --------------------------------
    // Returns the horizontal position of the cell's center
    // * out-parameters :
    // - "centerX", int : the horizontal position of the cell's center
    // ----------------------------------------------
    public int getCenterX() {
        return centerX;
    }

    // -- getCenterY --------------------------------
    // Returns the vertical position of the cell's center
    // * out-parameters :
    // - "centerY", int : the vertical position of the cell's center
    // ----------------------------------------------
    public int getCenterY() {
        return centerY;
    }

    // -- setCenterX --------------------------------
    // Sets the horizontal position of the cell's center
    // ----------------------------------------------
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    // -- setCenterY --------------------------------
    // Sets the vertical position of the cell's center
    // ----------------------------------------------
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    // -- getColor ----------------------------------
    // Returns the cell's color
    // * out-parameters :
    // - "color", Color : the cell's color
    // ----------------------------------------------
    public Color getColor() {
        return this.color;
    }

    // -- setColor ----------------------------------
    // Sets the cell's color
    // ----------------------------------------------
    public void setColor(Color color) {
        this.color = color;
    }
}
