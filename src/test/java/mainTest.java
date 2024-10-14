import CItester.adventureGame.Main;
import CItester.adventureGame.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class mainTest {

    @Test
    public void boolTest(){
        Main main = new Main();
        boolean isb = main.isBool();

        assertEquals(isb, true);
    }

    @Test
    public void canPlayerMoveBack(){
        Player player = new Player();


    }


}
