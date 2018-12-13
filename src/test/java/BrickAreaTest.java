import game.initializers.BrickAreaFromParameters;
import game.parameters.Parameters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrickAreaTest extends BrickAreaFromParameters {

    @Test
    public void shouldReturnDivisionResult(){
        assertEquals(15.0/ Parameters.getInstance().getBrickAreasLowerBorderYcoordCoef(), calculateLowerY(15.0), 0.001);
        assertEquals(0.0/Parameters.getInstance().getBrickAreasLowerBorderYcoordCoef(), calculateLowerY(0.0), 0.001);
    }
}
