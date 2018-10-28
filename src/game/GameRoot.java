package game;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

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

    public <T extends Shape>void addNode(T node){
       observableList.add(node);
    }

    public void addNodes(ArrayList<Brick> nodeList){
        for(Brick brick : nodeList){
            addNode(brick.getShape());
        }
    }


}
