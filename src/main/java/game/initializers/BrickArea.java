package game.initializers;

//Behavioral STRATEGY pattern
public interface BrickArea {
    double getWidth();
    double getHeight();
    double getLowerY();
    double getUpperY();
    double getLeftX();
    double getRightX();
}
