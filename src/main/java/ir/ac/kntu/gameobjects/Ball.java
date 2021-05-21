package ir.ac.kntu.gameobjects;

import ir.ac.kntu.constants.GlobalConstants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball implements GameObject{
    private double radius;
    private double xPos;
    private double yPos;
    private int xSpeed;
    private int ySpeed;
    private int layer;
    private int scale;

    public Ball(int xSpeed, int ySpeed) {
        this.radius = GlobalConstants.BALL_RADIUS;
        this.xPos = GlobalConstants.BALL_FIRST_POS_X;
        this.yPos = GlobalConstants.BALL_FIRST_POS_Y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.layer = 1;
        this.scale = 1;
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
        gc.setFill(Color.RED);
        gc.fillOval(xPos, yPos, radius, radius);

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

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }
}
