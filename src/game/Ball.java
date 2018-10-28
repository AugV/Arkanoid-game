package game;

import javafx.scene.shape.Circle;

public class Ball {
    private Circle shape;

    public Ball() {
        shape = new Circle(500, 300, 10);
    }

    public Circle getShape() {
        return shape;
    }


    public void move(double X, double Y) {
        shape.setCenterX(shape.getCenterX() + X);
        shape.setCenterY(shape.getCenterY() + Y);
    }
}
