package game.layout;

import game.objects.Brick;
import game.objects.GameObject;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.util.List;

public class GameRoot<T extends Pane> {
    private T pane;
    private ObservableList observableList;

    public GameRoot(T pane) {
        this.pane = pane;
        this.observableList = pane.getChildren();
    }

    public T getPane() {
        return pane;
    }

    public <T extends Shape> void addNode(T... shapes) {
        for (T nodeShape : shapes) {
            observableList.add(nodeShape);
        }
    }

    public void removeFromRoot(GameObject gameObject){
        observableList.remove(gameObject.getShape());
    }

    public void addNodeList(List<Brick> nodeList) {
        for (Brick brick : nodeList) {
            addNode(brick.getShape());
        }
    }

    public ObservableList getObservableList() {
        return observableList;
    }
}
