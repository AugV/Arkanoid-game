package game.core;

import game.layout.GameRoot;
import game.layout.GameScene;
import game.layout.GameStage;
import game.main.Main;
import game.parameters.Parameters;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameLayout {
    private GameStage gameStage;
    private GameRoot root;
    private GameScene gameScene;
    private GameObjects gameObjects;

    public GameLayout(Stage primaryStage) {
        setGameObjects();
        setRoot();
        addObjectsToLayout();
        setScene();
        setGameStage(primaryStage);
    }

    public void setGameObjects() {
        this.gameObjects = Main.gameObjects;
    }

    public void setRoot() {
        this.root = new GameRoot(new Pane());
    }

    public void addObjectsToLayout() {
        root.addNode(gameObjects.getTheVaus().getShape(), gameObjects.getBall().getShape());
        root.addNodeList(gameObjects.getBrickList());
    }

    public void setScene() {
        this.gameScene = new GameScene(root.getPane(),
                            Parameters.getInstance().getSceneWidth(),
                            Parameters.getInstance().getSceneHeight());
    }

    public void setGameStage(Stage stage) {
        gameStage = new GameStage(stage);
        gameStage.setTitle(Parameters.getInstance().getWindowTitle());
        gameStage.setScene(gameScene.getScene());
        gameStage.show();
    }

    public GameScene getGameScene() {
        return gameScene;
    }

    public GameRoot getRoot() {
        return root;
    }
}
