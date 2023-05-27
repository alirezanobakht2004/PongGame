package ir.ac.kntu;

import ir.ac.kntu.constants.GlobalConstants;
import ir.ac.kntu.gamecontroller.EventHandler;
import ir.ac.kntu.gameobjects.Ball;
import ir.ac.kntu.gameobjects.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.util.Random;

import static ir.ac.kntu.constants.GlobalConstants.*;

public class Game extends Application {

    private static Player playerOne;
    private static Player playerTwo;
    private static Ball ball;
    private GameState gameState;
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public static void main(String[] args) {
        playerOne = new Player(false);
        playerTwo = new Player(true);
        ball = new Ball(1, 1);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Pong-Game");
        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10),
                e -> start(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        Scene scene = new Scene(new Pane(canvas));
        canvas.setOnMouseClicked(e -> gameState = GameState.RUNNING);
        canvas.setOnMouseMoved(e -> playerOne.setYPos(e.getY()));
        stage.setScene(scene);
        stage.show();
        tl.play();
    }

    public void start(GraphicsContext gc) {
        gc.setFill(Color.rgb(222, 117, 117));
        gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));
        startRunning(gc);
        if (ball.getPositionX() > playerTwo.getPositionX() + PLAYER_WIDTH) {
            playerOneScore++;
            gameState = GameState.FINISHED;
        }
        if (ball.getPositionY() > CANVAS_HEIGHT - BALL_RADIUS || ball.getPositionY() < 0) {
            ball.setYSpeed(ball.getYSpeed() * (-1));
        }
        if (((ball.getPositionX() + BALL_RADIUS > playerTwo.getPositionX()) && ball.getPositionY() >=
                playerTwo.getPositionY() && ball.getPositionY() <= playerTwo.getPositionY() + PLAYER_HEIGHT)
                || ((ball.getPositionX() < playerOne.getPositionX() + PLAYER_WIDTH) &&
                ball.getPositionY() >= playerOne.getPositionY() && ball.getPositionY() <= playerOne.getPositionY() + PLAYER_HEIGHT)) {
            ball.setYSpeed((int) (Math.signum(ball.getYSpeed()) + ball.getYSpeed()));
            ball.setXSpeed((int) (Math.signum(ball.getXSpeed()) + ball.getXSpeed()));

            ball.setXSpeed(ball.getXSpeed() * (-1));
            ball.setYSpeed(ball.getYSpeed() * (-1));
        }

        gc.fillText(playerOneScore + "\t\t\t\t\t\t\t\t" + playerTwoScore, CANVAS_WIDTH / 2, 100);

        gc.fillRect(playerTwo.getPositionX(), playerTwo.getPositionY(), PLAYER_WIDTH, PLAYER_HEIGHT);
        gc.fillRect(playerOne.getPositionX(), playerOne.getPositionY(), PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    public void startRunning(GraphicsContext gc) {
        if (gameState == GameState.RUNNING) {
            ball.setXPos(ball.getPositionX() + ball.getXSpeed());
            ball.setYPos(ball.getPositionY() + ball.getYSpeed());

            if (ball.getPositionX() < CANVAS_WIDTH - CANVAS_WIDTH / 4) {
                playerTwo.setYPos(ball.getPositionY() - PLAYER_HEIGHT / 2);
            } else {
                playerTwo.setYPos(ball.getPositionY() > playerTwo.getPositionY() +
                        PLAYER_HEIGHT / 2 ? playerTwo.getPositionY() + 1 : playerTwo.getPositionY() - 1);
            }
            ball.draw(gc);
        } else {
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Click to start game", CANVAS_WIDTH / 2 - 30,
                    GlobalConstants.CANVAS_HEIGHT / 2);
            ball.setXPos((double) CANVAS_WIDTH / 2);
            ball.setYPos((double) CANVAS_HEIGHT / 2);
            ball.setXSpeed(new Random().nextInt(2) == 0 ? 1 : -1);
            ball.setYSpeed(new Random().nextInt(2) == 0 ? 1 : -1);
        }

        if (ball.getPositionX() < playerOne.getPositionX() - PLAYER_WIDTH) {
            playerTwoScore++;
            gameState = GameState.FINISHED;
        }
    }
}
