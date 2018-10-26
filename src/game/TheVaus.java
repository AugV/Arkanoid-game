package game;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class TheVaus {
        private Rectangle vaus;

    public TheVaus(double width, double height, double primaryPositionX, double fixedPositionY) {
        this.vaus = new Rectangle(width, height);
        vaus.setX(primaryPositionX);
        vaus.setY(fixedPositionY);
    }

    public Rectangle getVausObject() {
        return vaus;
    }

    public void moveLeft(){
        vaus.setX((vaus.getX()-100));
    }

    public void moveRight(){
        vaus.setX((vaus.getX()+100));
    }

}
