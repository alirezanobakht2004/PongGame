package ir.ac.kntu.gameobjects;

import ir.ac.kntu.constants.Direction;
import ir.ac.kntu.constants.GlobalConstants;
import javafx.scene.canvas.GraphicsContext;

import static ir.ac.kntu.constants.GlobalConstants.PLAYER_HEIGHT;
import static ir.ac.kntu.constants.GlobalConstants.PLAYER_WIDTH;

public class Player implements GameObject{
    private int height;
    private int width;
    private boolean isComputer;
    private double xPos;
    private double yPos;
    private Direction currentDir;
    private int layer;
    private int scale;

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
        this.currentDir = Direction.DOWN;
        this.layer = 1;
        this.scale = 1;
    }

    public void move(int step, Direction direction) {
        //TODO complete

    }

    @Override
    public boolean isColliding(GameObject b) {
        return false;
    }

    @Override
    public boolean isPlayerCollisionFriendly() {
        return false;
    }

    @Override
    public void draw(GraphicsContext gc) {
        //TODO complete

    }

    @Override
    public void removeFromScene() {

    }

    @Override
    public double getPositionX() {
        return xPos;
    }

    @Override
    public double getPositionY() {
        return yPos;
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public int getScale() {
        return scale;
    }

    public void setXPos(double xPos) {
        this.xPos = xPos;
    }

    public void setYPos(double yPos) {
        this.yPos = yPos;
    }
}