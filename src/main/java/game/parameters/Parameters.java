package game.parameters;

import game.objects.BrickType;

public class Parameters {

    private static final Parameters parameters = new Parameters();

    private final String windowTitle = "Arkanoid";
    private final double sceneWidth = 1024.0, sceneHeight = 768.0;
    private final double vausWidth = sceneWidth / 5.0, vausHeight = sceneHeight / 38.0;
    private final double vausPrimaryPositionX = ((sceneWidth - vausWidth) / 2.0), vausFixedPositionY = sceneHeight - vausHeight;
    private final double brickAreasLowerBorderYcoordCoef = 4.0;
    private final double brickAreasUpperBorderYcoordCoef = 10.0;
    private final double brickRowCount = 5.0;
    private final double brickColumnCount = 5.0;
    private final double ballSpeedHorizontal = 5.0;
    private final double ballSpeedVertical = 5.0;
    private final int ballLocX = 500;
    private final int ballLocY = 300;
    private final int ballRadius = 10;
    private final int vausSpeed = 30;
    private final BrickType brickType = BrickType.BRICK;

    private Parameters() {
    }

    public BrickType getBrickType() {
        return brickType;
    }

    public static Parameters getInstance() {
        return parameters;
    }

    public static Parameters getParameters() {
        return parameters;
    }

    public String getWindowTitle() {
        return windowTitle;
    }

    public double getSceneWidth() {
        return sceneWidth;
    }

    public double getSceneHeight() {
        return sceneHeight;
    }

    public double getVausWidth() {
        return vausWidth;
    }

    public double getVausHeight() {
        return vausHeight;
    }

    public double getVausPrimaryPositionX() {
        return vausPrimaryPositionX;
    }

    public double getVausFixedPositionY() {
        return vausFixedPositionY;
    }

    public double getBrickAreasLowerBorderYcoordCoef() {
        return brickAreasLowerBorderYcoordCoef;
    }

    public double getBrickAreasUpperBorderYcoordCoef() {
        return brickAreasUpperBorderYcoordCoef;
    }

    public double getBrickRowCount() {
        return brickRowCount;
    }

    public double getBrickColumnCount() {
        return brickColumnCount;
    }

    public double getBallSpeedHorizontal() {
        return ballSpeedHorizontal;
    }

    public double getBallSpeedVertical() {
        return ballSpeedVertical;
    }

    public int getBallLocX() {
        return ballLocX;
    }

    public int getBallLocY() {
        return ballLocY;
    }

    public int getBallRadius() {
        return ballRadius;
    }

    public int getVausSpeed() {
        return vausSpeed;
    }
}
