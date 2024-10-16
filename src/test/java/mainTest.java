import CItester.adventureGame.Main;
import CItester.adventureGame.Player;
import CItester.adventureGame.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class mainTest {

    @Test
    public void boolTest(){
        Main main = new Main();
        boolean isb = main.isBool();

        assertEquals(isb, true);
    }
}
