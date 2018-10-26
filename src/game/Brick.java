package game;

import javafx.scene.shape.Rectangle;

public class Brick {

    private Rectangle brick;

    public Brick(double positionX, double positionY, double width, double height) {
        this.brick = new Rectangle(positionX, positionY, width, height);
    }

}
