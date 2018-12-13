package game.rules;

import game.layout.GameRoot;
import game.objects.Ball;
import game.objects.Brick;
import game.objects.GameObject;
import game.objects.TheVaus;
import game.parameters.Parameters;
import javafx.animation.AnimationTimer;

import java.util.List;

public class GameRules {
    private Ball ball;
    private TheVaus vaus;
    private List<Brick> brickList;
    private GameRoot root;
    private double ballSpeedX = Parameters.getInstance().getBallSpeedHorizontal(),
                    ballSpeedY = Parameters.getInstance().getBallSpeedVertical();

    public GameRules(Ball ball, TheVaus vaus, List brickList, GameRoot gameRoot) {
        this.ball = ball;
        this.vaus = vaus;
        this.brickList = brickList;
        this.root = gameRoot;
    }

    public void startTimer() {
        animationTimer.start();
    }

    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            processMovement();
        }
    };

    public void processMovement() {
        adjustInCaseOfCollision();
        ball.move(ballSpeedX, ballSpeedY);
    }

    private void adjustInCaseOfCollision() {
        if (contactedFloor()) {
            gameOver();
        } else if (hitWallX()) {
            ballSpeedX = reverseDirection(ballSpeedX);
        } else if (hitWallY() || contactedVaus() || contactedBrick()) {
            ballSpeedY = reverseDirection(ballSpeedY);
        }
    }

    public boolean contactedFloor() {
        return ball.getCenterY() + ball.getRadius()
                > Parameters.getInstance().getSceneHeight();
    }

    private void gameOver() {
        System.out.println("GAME OVER!!");
        System.exit(666);
    }

    public boolean hitWallX() {
        return ball.getCenterX() - ball.getRadius() < 0
                || ball.getCenterX() + ball.getRadius() > Parameters.getInstance().getSceneWidth();
    }

    public boolean hitWallY() {
        return ball.getCenterY() - ball.getRadius() < 0;
    }

    public Double reverseDirection(Double direction) {
        return direction *= -1.0;
    }

    public boolean contactedVaus() {
        return ball.intersects((vaus.getShape().getLayoutBounds()));
    }

    public boolean contactedBrick() {
        for (GameObject obj : brickList) {
            if (ball.intersects(obj.getBounds())) {
                brickList.remove(obj);
                root.removeFromRoot(obj);
                return true;
            }
        }
        return false;
    }


}


