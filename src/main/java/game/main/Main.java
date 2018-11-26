package game.main;

import game.engine.GameRules;
import game.engine.UserInteraction;
import game.objects.GameObjects;
import game.layout.GameLayout;
import javafx.application.Application;

import javafx.stage.Stage;

import static game.parameters.Parameters.windowTitle;

public class Main extends Application {
    public static GameObjects gameObjects;
    public static GameLayout gameLayout;

    @Override
    public void init() {
        gameObjects = new GameObjects();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameLayout = new GameLayout(primaryStage);

        GameRules gameRules = new GameRules();

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
