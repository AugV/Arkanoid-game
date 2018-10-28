package game;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class TheVaus implements Movable {
        private Rectangle vaus;

    public TheVaus(double width, double height, double primaryPositionX, double fixedPositionY) {
        this.vaus = new Rectangle(width, height);
        vaus.setX(primaryPositionX);
        vaus.setY(fixedPositionY);
    }

    public Rectangle getVausObject() {
        return vaus;
    }

    public boolean isAtLeftWall(){
        return vaus.getX() < 0;
    }

    public boolean isAtRightWall(){
        return vaus.getX()+vaus.getWidth() > vaus.getParent().getLayoutBounds().getMaxX();
    }

    public void moveLeft(){
        if (isAtLeftWall()){

        } else{
        vaus.setX((vaus.getX()-30));}
    }

    public void moveRight(){
        if (isAtRightWall()){

        }
        else {
        vaus.setX((vaus.getX()+30));}
    }

}
