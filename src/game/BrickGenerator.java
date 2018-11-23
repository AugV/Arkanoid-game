package game;

import game.objects.Brick;

import java.util.ArrayList;
import java.util.List;

public class BrickGenerator {
    private double brickWidth, brickHeight;
    private BrickArea brickArea;
    private List<Brick> brickList = new ArrayList<>();

    public BrickGenerator(BrickArea area) {
        brickWidth = area.getWidth() / 5.0;
        brickHeight = area.getHeight() / 5.0;
        brickArea = area;
    }

    public void fillArea() {
        int brickId = 0;
        for (double coordY = brickArea.getUpperY(); coordY < brickArea.getLowerY()-1; ) {
            for (double coordX = brickArea.getLeftX(); coordX < brickArea.getRightX()-1; ) {
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

