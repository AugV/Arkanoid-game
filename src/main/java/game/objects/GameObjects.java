package game.objects;

import game.initializers.BrickArea;
import game.initializers.BrickGenerator;
import game.objects.Ball;
import game.objects.Brick;
import game.objects.TheVaus;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

import static game.parameters.Parameters.*;

public class GameObjects {
    private TheVaus theVaus;
    private Ball ball;
    private List<Brick> brickList;

    public GameObjects() {
        initializeBrickList();
        initializeTheVaus();
        initializeBall();
    }

    public void initializeBrickList() {
        BrickGenerator brickGenerator = new BrickGenerator(new BrickArea(sceneWidth, sceneHeight));
        brickGenerator.fillArea();
        brickList = brickGenerator.getBrickList();
    }

    public void initializeTheVaus() {
        theVaus = new TheVaus(vausWidth, vausHeight, vausPrimaryPositionX, vausFixedPositionY);
    }

    public TheVaus getTheVaus() {
        return theVaus;
    }

    public Ball getBall() {
        return ball;
    }

    public List<Brick> getBrickList() {
        return brickList;
    }

    public List getBrickShapeList() {
        List<Rectangle> shapeList = new ArrayList();
        for(Brick brick: brickList){
            shapeList.add(brick.getShape());
        }
        return shapeList;
    }

    public void initializeBall() {
        this.ball = new Ball();
    }

}
