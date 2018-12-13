package game.initializers;

import game.objects.Brick;
import game.parameters.Parameters;

import java.util.ArrayList;
import java.util.List;

public class BrickGenerator {
    private double brickWidth, brickHeight;
    private BrickArea brickArea;
    private List<Brick> brickList = new ArrayList();

    public BrickGenerator(BrickArea area) {
        brickWidth = area.getWidth() / Parameters.getInstance().getBrickColumnCount();
        brickHeight = area.getHeight() / Parameters.getInstance().getBrickRowCount();
        brickArea = area;
    }
//todo pakeisti i factory methoda
    //todo igyvendinti behavioral paterna
    public void fillArea() {
        int brickId = 0;
        for (double coordY = brickArea.getUpperY(); coordY < brickArea.getLowerY() - 1; ) {
            for (double coordX = brickArea.getLeftX(); coordX < brickArea.getRightX() - 1; ) {
                brickList.add(new Brick(coordX, coordY, brickWidth, brickHeight));
                coordX += brickWidth;
                brickId++;
            }
            coordY += brickHeight;
        }
    }

    public List<Brick> getBrickList() {
        return brickList;
    }



}

