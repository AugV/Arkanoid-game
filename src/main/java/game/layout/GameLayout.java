package game.layout;

import game.initializers.GameObjects;
import game.main.Main;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static game.parameters.Parameters.sceneHeight;
import static game.parameters.Parameters.sceneWidth;

public class GameLayout {
    private GameStage stage;
    private GameRoot root;
    private GameScene gameScene;
    private GameObjects gameObjects;

    public GameLayout(Stage primaryStage) {
        setStage(primaryStage);
        setRoot();
        setGameObjects();
        addNodesToRoot();
        setScene();
    }

    public GameStage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = new GameStage(stage);
    }

    public void setRoot() {
        this.root = new GameRoot(new Pane());
    }

    public void setScene() {
        this.gameScene = new GameScene(root.getPane(), sceneWidth, sceneHeight);
    }

    public void setGameObjects() {
        this.gameObjects = Main.gameObjects;
    }

    public GameScene getGameScene() {
        return gameScene;
    }

    public GameRoot getRoot() {
        return root;
    }

    public void addNodesToRoot() {
        root.addNode(gameObjects.getTheVaus().getShape(), gameObjects.getBall().getShape());
        root.addNodeList(gameObjects.getBrickList());
    }
}
