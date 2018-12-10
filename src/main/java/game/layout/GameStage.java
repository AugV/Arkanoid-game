package game.layout;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameStage {
    private Stage gameStage;

    public GameStage(Stage primaryStage){
        this.gameStage= primaryStage;
    }

    public void setTitle(String title){
        gameStage.setTitle(title);
    }

    public void setScene(Scene scene){
        gameStage.setScene(scene);
    }

    public void show(){
        gameStage.show();
    }
}
