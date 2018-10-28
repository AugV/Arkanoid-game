package game;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class UserInteraction <T extends Movable> {
    Scene objectToInteract;
    GameRules gameRules;
    T shape;

    public UserInteraction(Scene scene, T shape, GameRules gameRules) {
        objectToInteract = scene;
        this.shape = shape;
        this.gameRules = gameRules;
    }

    public void setKeys() {
        objectToInteract.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    shape.moveLeft();
                } else if (event.getCode() == KeyCode.RIGHT) {
                    shape.moveRight();
                } else if (event.getCode() == KeyCode.SPACE) {
                    gameRules.startTimer();

                }
            }
        });}


    }