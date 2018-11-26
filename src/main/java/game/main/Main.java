package game.main;

import game.engine.GameRules;
import game.engine.UserInteraction;
import game.initializers.GameObjects;
import game.layout.GameLayout;
import javafx.application.Application;

import javafx.stage.Stage;

import static game.parameters.Parameters.windowTitle;

public class Main extends Application {
    public static GameObjects gameObjects;
    static GameLayout gameLayout;

    @Override
    public void init() {
        gameObjects = new GameObjects();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameLayout = new GameLayout(primaryStage);

//        GameStage gameStage = new GameStage(primaryStage);
//        GameRoot gameRoot = new GameRoot(new Pane());
//        gameRoot.addNode(theVaus.getVausObject());
//        gameRoot.addNodeList(brickGenerator.getBrickList());
//        gameRoot.addNode(ball.getShape());

        GameRules gameRules = new GameRules(gameObjects.getBall(),
                gameObjects.getTheVaus(),
                gameObjects.getBrickList(), gameLayout.getRoot());
//        GameScene gameScene = new GameScene(gameRoot.getPane(), sceneWidth, sceneHeight);

        UserInteraction userInteraction = new UserInteraction(gameLayout.getGameScene().getScene(),
                gameObjects.getTheVaus(), gameRules);
        userInteraction.setKeys();

        gameLayout.getStage().setTitle(windowTitle);
        gameLayout.getStage().setScene(gameLayout.getGameScene().getScene());
        gameLayout.getStage().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
