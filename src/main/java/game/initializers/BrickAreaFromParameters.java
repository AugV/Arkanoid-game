package game.initializers;

import game.parameters.Parameters;

public class BrickAreaFromParameters implements BrickArea {
    private double lowerY, upperY, leftX, rightX, width, height;

    public BrickAreaFromParameters() {
    }

    public BrickAreaFromParameters(double screenWidth, double screenHeight){
        lowerY = calculateLowerY(screenHeight);
        upperY = calculateUpperY(screenHeight);
        leftX = 0.0;
        rightX = screenWidth;
        width = rightX - leftX;
        height = lowerY - upperY;
    }

    public double calculateUpperY(double screenHeight) {
        return screenHeight/ Parameters.getInstance().getBrickAreasUpperBorderYcoordCoef();
    }

    public double calculateLowerY(double screenHeight) {
        return screenHeight/Parameters.getInstance().getBrickAreasLowerBorderYcoordCoef();
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLowerY() {
        return lowerY;
    }

    public double getUpperY() {
        return upperY;
    }

    public double getLeftX() {
        return leftX;
    }

    public double getRightX() {
        return rightX;
    }
}
