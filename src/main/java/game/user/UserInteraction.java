package game.user;

import game.objects.Movable;
import game.rules.GameRules;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class UserInteraction <T extends Movable> {
    private Scene context;
    private GameRules rules;
    private T manipulatedObject;

    public UserInteraction(Scene scene, T manipulatedObject, GameRules gameRules) {
        context = scene;
        this.manipulatedObject = manipulatedObject;
        this.rules = gameRules;
        setKeys();
    }

    public void setKeys() {
        context.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    manipulatedObject.moveLeft();
                } else if (event.getCode() == KeyCode.RIGHT) {
                    manipulatedObject.moveRight();
                } else if (event.getCode() == KeyCode.SPACE) {
                    rules.startTimer();
                }
            }
        });}


    }