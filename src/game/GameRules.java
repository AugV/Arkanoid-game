package game;

import java.util.ArrayList;

public class GameRules {
    private Ball ball;
    private TheVaus vaus;
    private ArrayList<Brick> brickList;
    private GameRoot root;
    private double directionX = 20.0, directionY = 20.0;

    public GameRules(Ball ball, TheVaus vaus, ArrayList<Brick> brickList, GameRoot gameRoot) {
        this.ball = ball;
        this.vaus = vaus;
        this.brickList = brickList;
        this.root = gameRoot;
    }

    public boolean hitWallX() {
        return ball.getShape().getCenterX() - ball.getShape().getRadius() < 0
                || ball.getShape().getCenterX() + ball.getShape().getRadius() > 1024.0;
    }

    public boolean hitWallY() {
        return ball.getShape().getCenterY() - ball.getShape().getRadius() < 0
                || ball.getShape().getCenterY() + ball.getShape().getRadius() > 764.0;
    }

    public boolean contactedVaus() {
        return ball.getShape().intersects(vaus.getVausObject().getLayoutBounds());
    }

    public boolean contactedBrick() {
        for (Brick brick : brickList){
            if(ball.getShape().intersects(brick.getShape().getLayoutBounds())){
                brickList.remove(brick);
                root.getObservableList().remove(brick.getShape());
                return true;
            }
        }
        return false;
    }


    public void processMovement() {
        if (hitWallX()) {
            directionX = directionX * -1.0;
        } else if (hitWallY()) {
            directionY = directionY * -1.0;
        } else if (contactedVaus()) {
            directionY = directionY * -1.0;
        } else if (contactedBrick()) {
            directionY = directionY * -1.0;
        }

        ball.move(directionX, directionY);
    }

}


