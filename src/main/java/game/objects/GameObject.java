package game.objects;

import javafx.geometry.Bounds;
import javafx.scene.shape.Shape;

public interface GameObject {
    Shape getShape();
    Bounds getBounds();
}
