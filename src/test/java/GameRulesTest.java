import game.rules.GameRules;
import game.layout.GameRoot;
import game.objects.Ball;
import game.objects.Brick;
import game.objects.TheVaus;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static game.parameters.Parameters.*;
import static game.parameters.Parameters.ballSpeedVertical;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class GameRulesTest {
    private GameRules gameRules;
    private Ball ball;
    private TheVaus vaus;
    private List<Brick> brickList;
    private GameRoot root;
    private double ballRadius = 5.0;
    private double ballSpeedX = ballSpeedHorizontal, ballSpeedY = ballSpeedVertical;

    @Before
    public void initialize() {
        ball = mock(Ball.class);
        vaus = mock(TheVaus.class);
        brickList = Arrays.asList(mock(Brick.class), mock(Brick.class), mock(Brick.class));
        root = mock(GameRoot.class);
        gameRules = new GameRules(ball, vaus, brickList, root);
    }

    @Test
    public void testsIfBallContactedVerticalWalls() {
        when(ball.getCenterX()).thenReturn(sceneWidth - ballRadius);
        when(ball.getRadius()).thenReturn(ballRadius);
        assertFalse(gameRules.hitWallX());

        when(ball.getCenterX()).thenReturn(0.0 + ballRadius);
        when(ball.getRadius()).thenReturn(ballRadius);
        assertFalse(gameRules.hitWallX());

        when(ball.getCenterX()).thenReturn(sceneWidth + 1);
        when(ball.getRadius()).thenReturn(ballRadius);
        assertTrue(gameRules.hitWallX());
    }

    @Test
    public void testsIfBallContactedVaus() {
        when(ball.intersects(vaus.getBounds())).thenReturn(true);
        assertTrue(gameRules.contactedVaus());

        when(ball.intersects(vaus.getBounds())).thenReturn(false);
        assertFalse(gameRules.contactedVaus());
    }


    @Test
    public void testsIfBallContactedFloor() {
        when(ball.getCenterY()).thenReturn(sceneHeight - ballRadius);
        when(ball.getRadius()).thenReturn(ballRadius);
        assertFalse(gameRules.contactedFloor());

        when(ball.getCenterY()).thenReturn(sceneHeight + ballRadius);
        when(ball.getRadius()).thenReturn(ballRadius);
        assertTrue(gameRules.contactedFloor());
    }

    @Test
    public void testIfBallMovementIsCalled(){
        gameRules.processMovement();
        verify(ball).move(ballSpeedX, ballSpeedY);
    }

    @Test
    public void reverseDirectionsShouldChangeNumberSign(){
        assertEquals(-1.0, gameRules.reverseDirection(1.0), 0.0);
        assertEquals(1.0, gameRules.reverseDirection(-1.0), 0.0);
        assertEquals(0.0, gameRules.reverseDirection(0.0), 0.0);
    }
}
