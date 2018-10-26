package game;


import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class UserInteraction {
    TheVaus objectToInteract;

    public UserInteraction(TheVaus object) {
        objectToInteract = object;

        objectToInteract.getVausObject().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    objectToInteract.moveLeft();
                } else if (event.getCode() == KeyCode.RIGHT) {
                    objectToInteract.moveRight();
                }
            }
        });
    }


}
