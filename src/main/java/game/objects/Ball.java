package game.objects;

import game.parameters.Parameters;
import javafx.geometry.Bounds;
import javafx.scene.shape.Circle;

public class Ball implements GameObject{
    private Circle shape;

    public Ball() {
        shape = new Circle(Parameters.getInstance().getBallLocX(),
                Parameters.getInstance().getBallLocY(),
                Parameters.getInstance().getBallRadius());
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

    @Override
    public Bounds getBounds() {
        return shape.getLayoutBounds();
    }
}
