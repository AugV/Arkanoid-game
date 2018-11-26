package game.engine;

import game.layout.GameRoot;
import game.objects.Ball;
import game.objects.Brick;
import game.objects.GameObjects;
import game.objects.TheVaus;
import javafx.animation.AnimationTimer;

import java.util.List;

import static game.main.Main.gameLayout;
import static game.main.Main.gameObjects;
import static game.parameters.Parameters.ballSpeedHorizontal;
import static game.parameters.Parameters.ballSpeedVertical;

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

    public GameRules() {
        this.ball = gameObjects.getBall();
        this.vaus = gameObjects.getTheVaus();
        this.brickList = gameObjects.getBrickList();
        this.root = gameLayout.getRoot();
    }


    public boolean hitWallX() {
        return ball.getShape().getCenterX() - ball.getShape().getRadius() < 0
                || ball.getShape().getCenterX() + ball.getShape().getRadius() > 1024.0;
    }

    public boolean hitWallY() {
        return ball.getShape().getCenterY() - ball.getShape().getRadius() < 0;
    }

    public boolean contactedVaus() {
        return ball.getShape().intersects(vaus.getShape().getLayoutBounds());
    }

    public boolean contactedBrick() {
        for (Brick brick : brickList) {
            if (ball.getShape().intersects(brick.getShape().getLayoutBounds())) {
                brickList.remove(brick);
                root.getObservableList().remove(brick.getShape());
                return true;
            }
        }
        return false;
    }

    public boolean contactedFloor() {
        return ball.getShape().getCenterY() + ball.getShape().getRadius()
                > ball.getShape().getParent().getLayoutBounds().getMaxY();
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
        return direction = direction * -1.0;
    }

    private void gameOver() {
        System.out.println("GAME OVER!!");
        System.exit(666);
    }

}


