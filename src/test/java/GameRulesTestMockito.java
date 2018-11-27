import game.engine.GameRules;
import game.layout.GameRoot;
import game.objects.Ball;
import game.objects.Brick;
import game.objects.TheVaus;
import javafx.geometry.Bounds;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;

import static game.parameters.Parameters.sceneWidth;
import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class GameRulesTestMockito {
    private GameRules gameRules;
    private Ball ball;
    private TheVaus vaus;
    private List<Brick> brickList;
    private GameRoot root;

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
        double ballRadius = 5.0;
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

}
