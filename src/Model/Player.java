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
    boolean hasPlayed = false;
    boolean hasWon = false;
    private Color color;
    ArrayList<ArrayList<Cell>> blocks;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        switch (this.playerNumber) {
            case 1:
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

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    public boolean getHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public boolean getHasPlayed() {
        return hasPlayed;
    }

    public void setHasPlayed(boolean hasPlayed) {
        this.hasPlayed = hasPlayed;
    }

    public void setIsPlaying(boolean playing) {
        isPlaying = playing;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<ArrayList<Cell>> getBlocks() {return blocks;}

}
