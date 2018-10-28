package game;

import javafx.scene.shape.Rectangle;

public class Brick {
    private int id;
    private Rectangle shape;

    public Brick(int id, double positionX, double positionY, double width, double height) {
        this.shape = new Rectangle(positionX, positionY, width, height);
        this.id = id;
    }

    public Rectangle getShape() {
        return shape;
    }


}
