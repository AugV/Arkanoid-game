package game;

import javafx.scene.layout.AnchorPane;

public class GameRoot {
    AnchorPane pane;

    public GameRoot() {
        this.pane = new AnchorPane();
    }

    public AnchorPane getPane() {
        return pane;
    }
}
