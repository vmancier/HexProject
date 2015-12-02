package Model;

import Application.Entities;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Eliott and Valentin on 19/10/2015.
 */
public class Player {
    private int playerNumber;
    private Color color;
    ArrayList<ArrayList<Cell>> blocks;

    // -- Player ------------------------------------
    // Creates a new player depending of its playerNumber
    // * in-parameters :
    // - "playerNumber", int : the player number (1 or 2)
    // ----------------------------------------------
    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        switch (this.playerNumber) {
            case 1: //if playerNumber == 1, then the player gets the color 1
                this.color = Entities.PLAYER1_COLOR;
                break;
            case 2:
                this.color = Entities.PLAYER2_COLOR;
                break;
        }
    }

    // -- initPlayer --------------------------------
    // Initializes the player
    // ----------------------------------------------
    public void initPlayer() {
        blocks = new ArrayList<>();
    }

    // -- getColor ----------------------------------
    // Returns the color of the player
    // * out-parameters :
    // - "color", Color : the player's color
    // ----------------------------------------------
    public Color getColor() {
        return color;
    }

    // -- getBlocks ---------------------------------
    // Returns the color of the player
    // * out-parameters :
    // - "blocks", ArrayList<ArrayList<Cell>> : the list of lists of cell's blocks
    // ----------------------------------------------
    public ArrayList<ArrayList<Cell>> getBlocks() {
        return blocks;
    }

    // -- toString ----------------------------------
    // Returns a string identifying the player (used for the victory panel)
    // * out-parameters :
    // - "str", String : the string
    // ----------------------------------------------
    public String toString(){
        String str = "player "+this.playerNumber;
        return str;
    }
}
