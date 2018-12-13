package game.objects;

import javafx.geometry.Bounds;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Sphere implements GameObject {
    private Circle shape;

    public Sphere(double positionX, double positionY, double radius) {
        this.shape = new Circle(positionX, positionY, radius);
    }

    public Circle getShape() {
        return shape;
    }

    @Override
    public Bounds getBounds() {
        return shape.getLayoutBounds();
    }

}
