package game;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameStage gameStage = new GameStage(primaryStage);
        String windowTitle = "Arkanoid";
        double sceneWidth = 1024.0, sceneHeight = 768.0;
        double vausWidth = sceneWidth / 5.0, vausHeight = sceneHeight / 38.0;
        double vausPrimaryPositionX = ((sceneWidth-vausWidth) / 2.0) , vausFixedPositionY = sceneHeight - vausHeight;

        TheVaus theVaus = new TheVaus(vausWidth, vausHeight, vausPrimaryPositionX, vausFixedPositionY);

        GameRoot gameRoot = new GameRoot(new Pane());
        gameRoot.addNode(theVaus.getVausObject());
        GameScene gameScene = new GameScene(gameRoot.getPane(), sceneWidth, sceneHeight);
        new UserInteraction(gameScene.getScene(), theVaus);


        gameStage.setTitle(windowTitle);
        gameStage.setScene(gameScene.getScene());
        gameStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
