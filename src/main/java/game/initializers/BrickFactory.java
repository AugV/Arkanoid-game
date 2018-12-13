package game.initializers;

import game.objects.Brick;
import game.objects.GameObject;
import game.objects.Sphere;
import game.parameters.Parameters;

import java.util.ArrayList;
import java.util.List;

public class BrickFactory {
    private double objectWidth, objectHeight;
    private BrickArea brickArea;
    private List<GameObject> brickList = new ArrayList();

    public BrickFactory() {
        brickArea = new BrickAreaFromParameters(Parameters.getInstance().getSceneWidth(),
                Parameters.getInstance().getSceneHeight());
        calculateObjectWidth();
        calculateObjectHeight();
    }

    private void calculateObjectHeight() {
        objectHeight = brickArea.getHeight() / Parameters.getInstance().getBrickRowCount();
    }

    private void calculateObjectWidth() {
        objectWidth = brickArea.getWidth() / Parameters.getInstance().getBrickColumnCount();
    }


    public void fillArea() {
        for (double coordY = brickArea.getUpperY(); coordY < brickArea.getLowerY() - 1; ) {
            for (double coordX = brickArea.getLeftX(); coordX < brickArea.getRightX() - 1; ) {
                addGameObjectToList(coordX, coordY, objectWidth, objectHeight);
                coordX += objectWidth;
            }
            coordY += objectHeight;
        }
    }

    private void addGameObjectToList(double coordX, double coordY, double objectWidth, double objectHeight) {
        GameObject newGameObject;
        switch (Parameters.getInstance().getBrickType()) {
            case BRICK:
                newGameObject = getNewBrick(coordX, coordY, objectWidth, objectHeight);
                break;
            case SPHERE:
                newGameObject = getNewSphere(coordX, coordY, objectHeight);
                break;
            default:
                throw new NullPointerException();
        }
        brickList.add(newGameObject);
    }

    private GameObject getNewBrick(double coordX, double coordY, double brickWidth, double brickHeight) {
        return new Brick(coordX, coordY, brickWidth, brickHeight);
    }

    private GameObject getNewSphere(double coordX, double coordY, double radius) {
        return new Sphere(coordX, coordY, radius);
    }

    public List<GameObject> getBrickList() {
        return brickList;
    }


}

