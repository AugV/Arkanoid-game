package game.parameters;

public class Parameters {
    //todo  padaryti sita singleton
    public static final String windowTitle = "Arkanoid";
    public static final double sceneWidth = 1024.0, sceneHeight = 768.0;
    public static final double vausWidth = sceneWidth / 5.0, vausHeight = sceneHeight / 38.0;
    public static final double vausPrimaryPositionX = ((sceneWidth-vausWidth) / 2.0) , vausFixedPositionY = sceneHeight - vausHeight;
    public static final double brickAreasLowerBorderYcoord = 4.0;
    public static final double brickAreasUpperBorderYcoord = 10.0;
    public static final double brickRowCount = 5.0;
    public static final double brickColumnCount = 5.0;
    public static final double ballSpeedHorizontal = 5.0;
    public static final double ballSpeedVertical = 5.0;
    public static final int ballLocX = 500;
    public static final int ballLocY = 300;
    public static final int ballRadius = 10;
    public static final int vausSpeed = 30;
}
