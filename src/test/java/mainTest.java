import CItester.adventureGame.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class mainTest {

    @Test
    public void boolTest(){
        Main main = new Main();
        boolean isb = main.isBool();

        assertEquals(isb, true);
    }


}
