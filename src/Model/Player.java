package Model;

import Application.Entities;

import java.awt.*;

/**
 * Created by Eliott on 19/10/2015.
 */
public class Player {
    private int index;
    private Color color;

    public Player(int index) {
        this.index = index;
        switch(this.index) {
            case 1:
                this.color = Entities.PLAYER1_COLOR;
                break;
            case 2:
                this.color = Entities.PLAYER2_COLOR;
                break;
        }
    }
}
