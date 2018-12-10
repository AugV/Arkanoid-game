package game.objects;

import javafx.geometry.Bounds;
import javafx.scene.shape.Circle;

import static game.parameters.Parameters.ballLocX;
import static game.parameters.Parameters.ballLocY;
import static game.parameters.Parameters.ballRadius;

public class Ball implements GameObject{
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

    public double getCenterX(){
        return shape.getCenterX();
    }

    public double getCenterY(){
        return shape.getCenterY();
    }

    public double getRadius(){
        return shape.getRadius();
    }

    public boolean intersects(Bounds bounds){
        return shape.intersects(bounds);
    }
}
