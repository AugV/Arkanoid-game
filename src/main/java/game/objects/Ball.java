package game.objects;

import javafx.scene.shape.Circle;

import static game.parameters.Parameters.ballLocX;
import static game.parameters.Parameters.ballLocY;
import static game.parameters.Parameters.ballRadius;

public class Ball {
    private Circle shape;

    public Ball() {
        shape = new Circle(ballLocX, ballLocY, ballRadius);
    }

    public Circle getShape() {
        return shape;
    }

    public void move(double X, double Y) {
        shape.setCenterX(shape.getCenterX() + X);
        shape.setCenterY(shape.getCenterY() + Y);
    }
}
