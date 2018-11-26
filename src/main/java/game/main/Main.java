package game.main;

import game.core.GameEngine;
import game.core.GameObjects;
import game.core.GameLayout;
import javafx.application.Application;

import javafx.stage.Stage;

public class Main extends Application {
    public static GameObjects gameObjects;
    public static GameLayout gameLayout;
    static GameEngine gameEngine;

    @Override
    public void init() {
        gameObjects = new GameObjects();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameLayout = new GameLayout(primaryStage);
        gameEngine = new GameEngine(gameObjects, gameLayout);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
