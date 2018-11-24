import game.engine.GameRules;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void reverseDirectionsShouldChangeNumberSign(){
        GameRules testRule = new GameRules();
        assertEquals(-1.0, testRule.reverseDirection(1.0), 1.0);
        assertEquals(1.0, testRule.reverseDirection(-1.0), -1.0);
        assertEquals(0.0, testRule.reverseDirection(0.0), 0.0);
    }
}
