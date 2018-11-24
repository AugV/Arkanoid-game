package game.layout;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene {
    Scene scene;

    public <T extends Parent> GameScene(T parentNode, double width, double height){
        this.scene = new Scene(parentNode, width, height);
    }

    public Scene getScene() {
        return scene;
    }

}
