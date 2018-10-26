package game;

import javafx.scene.shape.Rectangle;

public class TheVaus {
        private Rectangle vaus;

    public TheVaus(double width, double height, double primaryPositionX, double fixedPositionY) {
        this.vaus = new Rectangle(width, height);
        vaus.setX(primaryPositionX);
        vaus.setY(fixedPositionY);
    }

    public Rectangle getVaus() {
        return vaus;
    }

    public void changePosition(){
        vaus.setX((vaus.getX()-100));
    }

}
