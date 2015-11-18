package Model;

import Application.Entities;

import java.awt.*;

/**
 * Created by Eliott on 19/10/2015.
 */
public class Player {
    private int playerNumber;
    private int score = 0;
    boolean isPlaying = false;
    private Color color;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        switch(this.playerNumber) {
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

    public void setIsPlaying(boolean playing) {
        isPlaying = playing;
    }

    public Color getColor() {
        return color;
    }
}