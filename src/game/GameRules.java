package game;

public class GameRules {
    private Ball ball;
    private double directionX = 1, directionY = 1;

    public GameRules(Ball ball) {
        this.ball = ball;
    }

    public void process() {
        if (ball.getShape().getCenterX() == 0){
            directionX = 1.0;
        }
        else if(ball.getShape().getCenterX() == 1024.0) {
            directionX = -1.0;
        }
        else if (ball.getShape().getCenterY() == 0){
            directionY = 1.0;
        }
        else if (ball.getShape().getCenterY() == 764.0) {
            directionY = -1.0;

        }
        ball.move(directionX,directionY);
    }


}
