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

    public BrickFactory(BrickArea area) {
        objectWidth = area.getWidth() / Parameters.getInstance().getBrickColumnCount();
        objectHeight = area.getHeight() / Parameters.getInstance().getBrickRowCount();
        brickArea = area;
    }
//todo pakeisti i factory methoda
    //todo igyvendinti behavioral paterna
    public void fillArea() {
        int brickId = 0;
        for (double coordY = brickArea.getUpperY(); coordY < brickArea.getLowerY() - 1; ) {
            for (double coordX = brickArea.getLeftX(); coordX < brickArea.getRightX() - 1; ) {
//                brickList.add(getNewSphere(coordX, coordY, objectHeight));
                brickList.add(getNewBrick(coordX, coordY, objectWidth, objectHeight));
                coordX += objectWidth;
                brickId++;
            }
            coordY += objectHeight;
        }
    }

    private GameObject getNewBrick(double coordX, double coordY, double brickWidth, double brickHeight ){
        return new Brick(coordX, coordY, brickWidth, brickHeight);
    }

    private GameObject getNewSphere(double coordX, double coordY, double radius ){
        return new Sphere(coordX, coordY, radius);
    }


    public List<GameObject> getBrickList() {
        return brickList;
    }



}

