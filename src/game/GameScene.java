package game;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene {
    Scene scene;

    public <T extends Parent> GameScene(T parentNode){
        this.scene = new Scene(parentNode);
    }

    public Scene getScene() {
        return scene;
    }

}
