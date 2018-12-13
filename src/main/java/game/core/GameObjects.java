package game.core;

import game.initializers.BrickFactory;
import game.objects.Ball;
import game.objects.GameObject;
import game.objects.TheVaus;
import game.parameters.Parameters;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;


public class GameObjects {
    private TheVaus theVaus;
    private Ball ball;
    private List<GameObject> brickList;

    public GameObjects() {
        initializeBrickList();
        initializeTheVaus();
        initializeBall();
    }

    public void initializeBrickList() {
        BrickFactory brickFactory = new BrickFactory();
        brickFactory.fillArea();
        brickList = brickFactory.getBrickList();
    }

    public void initializeTheVaus() {
        theVaus = new TheVaus(Parameters.getInstance().getVausWidth(),
                Parameters.getInstance().getVausHeight(),
                Parameters.getInstance().getVausPrimaryPositionX(),
                Parameters.getInstance().getVausFixedPositionY());
    }

    public TheVaus getTheVaus() {
        return theVaus;
    }

    public Ball getBall() {
        return ball;
    }

    public List<GameObject> getBrickList() {
        return brickList;
    }

    public List getBrickShapeList() {
        List<Shape> shapeList = new ArrayList();
        for(GameObject obj: brickList){
            shapeList.add(obj.getShape());
        }
        return shapeList;
    }

    public void initializeBall() {
        this.ball = new Ball();
    }

}
