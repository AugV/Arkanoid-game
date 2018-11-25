package game.layout;

import game.initializers.GameObjectInitializer;
import game.main.Main;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static game.parameters.Parameters.sceneHeight;
import static game.parameters.Parameters.sceneWidth;

public class LayoutInitializer {
    private GameStage stage;
    private GameRoot root;
    private GameScene gameScene;
    private GameObjectInitializer gameObjects;

    public LayoutInitializer(Stage primaryStage) {
        setStage(primaryStage);
        setRoot();
        setGameObjects();
        setScene();
    }

    public GameStage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage= new GameStage(stage);
    }

    public void setRoot() {
        this.root = new GameRoot(new Pane());
    }

    public void setScene() {
        this.gameScene = new GameScene(root.getPane(), sceneWidth, sceneHeight);
    }
    public void setGameObjects() {
        this.gameObjects = Main.gameObjectInitializer;
    }

    public GameScene getGameScene() {
        return gameScene;
    }

    public GameRoot getRoot() {
        return root;
    }

    public void addNodesToRoot(){
        root.getObservableList().addAll(gameObjects.getBall().getShape(),
                //TODO arraylist cannot be cast to Node
                gameObjects.getBrickShapeList(),
                                        gameObjects.getTheVaus().getShape());
    }
}
