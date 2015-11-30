package Model;

import Application.Entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Eliott on 19/10/2015.
 */
public class Player {
    private int playerNumber;
    private int score = 0;
    boolean isPlaying = false;
    boolean hasWon = false;
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
            case 1: //if playerNumber == 1, then the player gets the color 1, and plays in first
                this.color = Entities.PLAYER1_COLOR;
                this.score = 0;
                this.isPlaying = true;
                break;
            case 2:
                this.color = Entities.PLAYER2_COLOR;
                this.score = 0;
                this.isPlaying = false;
                break;
        }
        blocks = new ArrayList<ArrayList<Cell>>();
    }

    // -- getPlayerNumber ---------------------------
    // Returns the player number
    // * out-parameters :
    // - "playerNumber", int : the player number
    // ----------------------------------------------
    public int getPlayerNumber() {
        return playerNumber;
    }

    // -- getScore ----------------------------------
    // Returns the score
    // * out-parameters :
    // - "score", int : the score
    // ----------------------------------------------
    public int getScore() {
        return score;
    }

    // -- setScore ----------------------------------
    // Sets the score
    // ----------------------------------------------
    public void setScore(int score) {
        this.score = score;
    }

    // -- getIsPlaying ------------------------------
    // Tells if the player is playing or not
    // * out-parameters :
    // - "isPlaying", boolean : true if the player is playing, false on the contrary
    // ----------------------------------------------
    public boolean getIsPlaying() {
        return isPlaying;
    }

    // -- setIsPlaying ------------------------------
    // Sets the is isPlaying boolean
    // * in-parameters :
    // - "playing", boolean : true if the player is playing, false on the contrary
    // ----------------------------------------------
    public void setIsPlaying(boolean playing) {
        isPlaying = playing;
    }

    // -- getHasWon ---------------------------------
    // Tells if the player has won or not
    // * out-parameters :
    // - "hasWon", boolean : true if the player has won, false on the contrary
    // ----------------------------------------------
    public boolean getHasWon() {
        return hasWon;
    }

    // -- setHasWon ---------------------------------
    // Sets the is isPlaying boolean
    // * in-parameters :
    // - "playing", boolean : true if the player has won, false on the contrary
    // ----------------------------------------------
    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    // -- getColor ---------------------------------
    // Returns the color of the player
    // * out-parameters :
    // - "color", Color : the player's color
    // ----------------------------------------------
    public Color getColor() {
        return color;
    }

    public ArrayList<ArrayList<Cell>> getBlocks() {return blocks;}

}
