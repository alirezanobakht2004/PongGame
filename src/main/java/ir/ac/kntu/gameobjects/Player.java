package ir.ac.kntu.gameobjects;

import ir.ac.kntu.constants.Direction;
import ir.ac.kntu.constants.GlobalConstants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static ir.ac.kntu.constants.GlobalConstants.PLAYER_HEIGHT;
import static ir.ac.kntu.constants.GlobalConstants.PLAYER_WIDTH;

public class Player implements GameObject {
    private int height;
    private int width;
    private boolean isComputer;
    private double xPos;
    private double yPos;


    public Player(boolean isComputer) {
        this.isComputer = isComputer;
        this.height = PLAYER_HEIGHT;
        this.width = PLAYER_WIDTH;
        if (isComputer) {
            this.xPos = GlobalConstants.COMPUTER_FIRST_POS_X;
            this.yPos = GlobalConstants.COMPUTER_FIRST_POS_Y;
        } else {
            this.xPos = GlobalConstants.PLAYER_FIRST_POS_X;
            this.yPos = GlobalConstants.PLAYER_FIRST_POS_Y;
        }
    }


    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.YELLOW);
        gc.fillRect(xPos, yPos, PLAYER_WIDTH, PLAYER_HEIGHT);
    }


    @Override
    public double getPositionX() {
        return xPos;
    }

    @Override
    public double getPositionY() {
        return yPos;
    }


    public void setXPos(double xPos) {
        this.xPos = xPos;
    }

    public void setYPos(double yPos) {
        this.yPos = yPos;
    }
}
