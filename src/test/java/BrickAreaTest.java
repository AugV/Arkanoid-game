import game.initializers.BrickArea;
import org.junit.Test;

import static game.parameters.Parameters.brickAreasLowerBorderYcoord;
import static org.junit.Assert.assertEquals;

public class BrickAreaTest extends BrickArea{

    @Test
    public void shouldReturnDivisionResult(){
        assertEquals(15.0/brickAreasLowerBorderYcoord, calculateLowerY(15.0), 0.001);
        assertEquals(0.0/brickAreasLowerBorderYcoord, calculateLowerY(0.0), 0.001);
    }
}
