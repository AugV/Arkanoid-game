package game;

import java.util.ArrayList;

public class BrickController {
    private double brickWidth, brickHeight;
    private BrickArea brickArea;
    private ArrayList<Brick> brickList = new ArrayList<>();

    public BrickController(BrickArea area) {
        brickWidth = area.getWidth() / 5.0;
        brickHeight = area.getHeight() / 5.0;
        brickArea = area;
    }

    public void fillArea() {
        int brickId = 0;
        for (double coordY = brickArea.getUpperY(); coordY < brickArea.getLowerY()-1; ) {
            for (double coordX = brickArea.getLeftX(); coordX < brickArea.getRightX()-1; ) {
                brickList.add(new Brick(brickId, coordX, coordY, brickWidth, brickHeight));
                coordX += brickWidth;
                brickId++;
            }
            coordY += brickHeight;
        }
    }

    public ArrayList<Brick> getBrickList() {
        return brickList;
    }

}

