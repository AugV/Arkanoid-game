package game.engine;

import game.layout.GameRoot;
import game.objects.Ball;
import game.objects.Brick;
import game.objects.TheVaus;
import javafx.animation.AnimationTimer;

import java.util.List;

public class GameRules {
    private Ball ball;
    private TheVaus vaus;
    private List<Brick> brickList;
    private GameRoot root;
    private double directionX = 5.0, directionY = 5.0;

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
    }

    public GameRules(Ball ball, TheVaus vaus, List<Brick> brickList, GameRoot gameRoot) {
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
        return ball.getShape().getCenterY() - ball.getShape().getRadius() < 0;
    }

    public boolean contactedVaus() {
        return ball.getShape().intersects(vaus.getVausObject().getLayoutBounds());
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
        ball.move(directionX, directionY);
    }

    private void adjustInCaseOfCollision() {
        if (contactedFloor()) {
            gameOver();
        } else if (hitWallX()) {
            directionX = reverseDirection(directionX);
        } else if (hitWallY() || contactedVaus() || contactedBrick()) {
            directionY = reverseDirection(directionY);
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


