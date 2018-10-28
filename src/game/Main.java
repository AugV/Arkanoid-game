package game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameStage gameStage = new GameStage(primaryStage);
        //region
        String windowTitle = "Arkanoid";
        double sceneWidth = 1024.0, sceneHeight = 768.0;
        double vausWidth = sceneWidth / 5.0, vausHeight = sceneHeight / 38.0;
        double vausPrimaryPositionX = ((sceneWidth-vausWidth) / 2.0) , vausFixedPositionY = sceneHeight - vausHeight;
//endregion

        TheVaus theVaus = new TheVaus(vausWidth, vausHeight, vausPrimaryPositionX, vausFixedPositionY);

        GameRoot gameRoot = new GameRoot(new Pane());
        gameRoot.addNode(theVaus.getVausObject());

        BrickController brickController = new BrickController(new BrickArea(sceneWidth, sceneHeight));
        brickController.fillArea();
        gameRoot.addNodes(brickController.getBrickList());

        Ball ball = new Ball();
        gameRoot.addNode(ball.getShape());

        GameRules gameRules = new GameRules(ball,theVaus, brickController.getBrickList(), gameRoot);

        GameScene gameScene = new GameScene(gameRoot.getPane(), sceneWidth, sceneHeight);
        new UserInteraction(gameScene.getScene(), theVaus);

        gameStage.setTitle(windowTitle);
        gameStage.setScene(gameScene.getScene());
        gameStage.show();

        gameRules.startTimer();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
