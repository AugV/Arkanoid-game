package game.engine;

import game.layout.GameRoot;
import game.objects.Ball;
import game.objects.Brick;
import game.objects.TheVaus;
import javafx.animation.AnimationTimer;

import java.util.List;

import static game.parameters.Parameters.*;

public class GameRules {
    private Ball ball;
    private TheVaus vaus;
    private List<Brick> brickList;
    private GameRoot root;
    private double ballSpeedX = ballSpeedHorizontal, ballSpeedY = ballSpeedVertical;

    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            processMovement();
        }
    };

    public void startTimer() {
        animationTimer.start();
    }

    public GameRules(Ball ball, TheVaus vaus, List brickList, GameRoot gameRoot) {
        this.ball = ball;
        this.vaus = vaus;
        this.brickList = brickList;
        this.root = gameRoot;
    }

    public GameRules() {
    }

    public boolean hitWallX() {
        return ball.getCenterX() - ball.getRadius() < 0
                || ball.getCenterX() + ball.getRadius() > sceneWidth;
    }

    public boolean hitWallY() {
        return ball.getCenterY() - ball.getRadius() < 0;
    }

    public boolean contactedVaus() {
        return ball.intersects(vaus.getBounds());
    }

    public boolean contactedBrick() {
        for (Brick brick : brickList) {
            if (ball.intersects(brick.getBounds())) {
                brickList.remove(brick);
                root.getObservableList().remove(brick.getShape());
                return true;
            }
        }
        return false;
    }

    public boolean contactedFloor() {
        return ball.getCenterY() + ball.getRadius()
                > sceneHeight;
    }

    public Ball getBall() {
        return ball;
    }

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

    public Double reverseDirection(Double direction) {
        return direction *= -1.0;
    }

    private void gameOver() {
        System.out.println("GAME OVER!!");
        System.exit(666);
    }

}


