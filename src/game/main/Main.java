package game.main;

import game.*;
import game.engine.GameRules;
import game.engine.UserInteraction;
import game.layout.GameRoot;
import game.layout.GameScene;
import game.layout.GameStage;
import game.objects.Ball;
import game.objects.TheVaus;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    static double sceneWidth = 1024.0, sceneHeight = 768.0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameStage gameStage = new GameStage(primaryStage);
        //region
        String windowTitle = "Arkanoid";
        double vausWidth = sceneWidth / 5.0, vausHeight = sceneHeight / 38.0;
        double vausPrimaryPositionX = ((sceneWidth-vausWidth) / 2.0) , vausFixedPositionY = sceneHeight - vausHeight;
//endregion

        TheVaus theVaus = new TheVaus(vausWidth, vausHeight, vausPrimaryPositionX, vausFixedPositionY);

        GameRoot gameRoot = new GameRoot(new Pane());
        gameRoot.addNode(theVaus.getVausObject());

        BrickGenerator brickGenerator = new BrickGenerator(new BrickArea(sceneWidth, sceneHeight));
        brickGenerator.fillArea();
        gameRoot.addNodes(brickGenerator.getBrickList());

        Ball ball = new Ball();
        gameRoot.addNode(ball.getShape());

        GameRules gameRules = new GameRules(ball,theVaus, brickGenerator.getBrickList(), gameRoot);
        GameScene gameScene = new GameScene(gameRoot.getPane(), sceneWidth, sceneHeight);

        UserInteraction userInteraction = new UserInteraction(gameScene.getScene(), theVaus, gameRules);
        userInteraction.setKeys();

        gameStage.setTitle(windowTitle);
        gameStage.setScene(gameScene.getScene());
        gameStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
