package ir.ac.kntu.gameobjects;

import javafx.scene.canvas.GraphicsContext;

public interface GameObject {

    void draw(GraphicsContext gc);
    double getPositionX();
    double getPositionY();

}
