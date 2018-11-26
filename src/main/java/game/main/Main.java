package game.main;

import game.engine.GameRules;
import game.engine.UserInteraction;
import game.initializers.GameObjectInitializer;
import game.layout.LayoutInitializer;
import javafx.application.Application;

import javafx.stage.Stage;

import static game.parameters.Parameters.windowTitle;

public class Main extends Application {
    public static GameObjectInitializer gameObjectInitializer;
    static LayoutInitializer layoutInitializer;

    @Override
    public void init() {
        gameObjectInitializer = new GameObjectInitializer();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        layoutInitializer = new LayoutInitializer(primaryStage);

//        GameStage gameStage = new GameStage(primaryStage);
//        GameRoot gameRoot = new GameRoot(new Pane());
//        gameRoot.addNode(theVaus.getVausObject());
//        gameRoot.addNodeList(brickGenerator.getBrickList());
//        gameRoot.addNode(ball.getShape());

        GameRules gameRules = new GameRules(gameObjectInitializer.getBall(),
                gameObjectInitializer.getTheVaus(),
                gameObjectInitializer.getBrickList(), layoutInitializer.getRoot());
//        GameScene gameScene = new GameScene(gameRoot.getPane(), sceneWidth, sceneHeight);

        UserInteraction userInteraction = new UserInteraction(layoutInitializer.getGameScene().getScene(),
                gameObjectInitializer.getTheVaus(), gameRules);
        userInteraction.setKeys();

        layoutInitializer.getStage().setTitle(windowTitle);
        layoutInitializer.getStage().setScene(layoutInitializer.getGameScene().getScene());
        layoutInitializer.getStage().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
