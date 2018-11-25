package game.initializers;

import game.objects.Brick;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

import static game.parameters.Parameters.brickColumnCount;
import static game.parameters.Parameters.brickRowCount;

public class BrickGenerator {
    private double brickWidth, brickHeight;
    private BrickArea brickArea;
    private List<Brick> brickList = new ArrayList();

    public BrickGenerator(BrickArea area) {
        brickWidth = area.getWidth() / brickColumnCount;
        brickHeight = area.getHeight() / brickRowCount;
        brickArea = area;
    }

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

