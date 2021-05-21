package ir.ac.kntu.gamecontroller;

import javafx.scene.input.KeyCode;


public class PlayerController implements InputManager {

    private static PlayerController instance = new PlayerController();

    public static PlayerController getInstance() {
        return instance;
    }

    private PlayerController() {}

    @Override
    public void handlePlayerMovements(KeyCode keyCode) {
        //TODO set controller

    }
}
