package game;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class UserInteraction <T extends Movable> {
    Scene objectToInteract;
    T node;

    public UserInteraction(Scene scene, T node) {
        objectToInteract = scene;
        this.node = node;
        objectToInteract.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    node.moveLeft();
                } else if (event.getCode() == KeyCode.RIGHT) {
                    node.moveRight();
                }
            }
        });
    }


}
