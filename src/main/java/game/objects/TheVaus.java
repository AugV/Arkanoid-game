package game.objects;

import game.parameters.Parameters;
import javafx.scene.shape.Rectangle;

public class TheVaus implements Movable {
    private Rectangle shape;

    public TheVaus(double width, double height, double primaryPositionX, double fixedPositionY) {
        this.shape = new Rectangle(width, height);
        shape.setX(primaryPositionX);
        shape.setY(fixedPositionY);
    }

    public Rectangle getShape() {
        return shape;
    }

    public boolean isAtLeftWall() {
        return shape.getX() <= 0;
    }

    public boolean isAtRightWall() {
        return shape.getX() + shape.getWidth() >= shape.getParent().getLayoutBounds().getMaxX();
    }

    public void moveLeft() {
        if (isAtLeftWall()) {
        } else {
            shape.setX((shape.getX() - Parameters.vausSpeed));
        }
    }

    public void moveRight() {
        if (isAtRightWall()) {
        } else {
            shape.setX((shape.getX() + Parameters.vausSpeed));
        }
    }

}
