package game;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String windowTitle = "Arkanoid";
        GameStage gameStage = new GameStage(primaryStage);
        GameRoot gameRoot = new GameRoot();
        GameScene gameScene = new GameScene(gameRoot.getPane());

        gameStage.setTitle(windowTitle);
        gameStage.setScene(gameScene.getScene());


        

        gameStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
