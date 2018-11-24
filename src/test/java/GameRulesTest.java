import game.engine.GameRules;
import junit.framework.TestCase;
import org.junit.Test;

public class GameRulesTest extends TestCase {
    protected GameRules gameRules;

    protected void setUp(){
        gameRules = new GameRules();
    }
    @Test
    public void reverseDirectionsShouldChangeNumberSign(){
        assertEquals(-1.0, gameRules.reverseDirection(1.0), 0.0);
        assertEquals(1.0, gameRules.reverseDirection(-1.0), 0.0);
        assertEquals(0.0, gameRules.reverseDirection(0.0), 0.0);
    }
}
