package game.objects;

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public class Brick {
    private Rectangle shape;

    public Brick(double positionX, double positionY, double width, double height) {
        this.shape = new Rectangle(positionX, positionY, width, height);
    }

    public Rectangle getShape() {
        return shape;
    }

    public Bounds getBounds(){
        return shape.getLayoutBounds();
    }
}
