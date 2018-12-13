import game.initializers.BrickArea;
import game.parameters.Parameters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrickAreaTest extends BrickArea{

    @Test
    public void shouldReturnDivisionResult(){
        assertEquals(15.0/ Parameters.getInstance().getBrickAreasLowerBorderYcoord(), calculateLowerY(15.0), 0.001);
        assertEquals(0.0/Parameters.getInstance().getBrickAreasLowerBorderYcoord(), calculateLowerY(0.0), 0.001);
    }
}
