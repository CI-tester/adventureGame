import CItester.adventureGame.Console;
import CItester.adventureGame.Player;
import CItester.adventureGame.Room;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleTests {

    @Test
    void doTurnTests(){
        Room[] rooms = {mock(Room.class)};
        Console c = new Console(mock(Player.class), rooms);

        when(c.doTurn(2)).thenReturn(true);

        boolean res1= c.doTurn(-1);
        boolean res2= c.doTurn(-0);
        boolean res3= c.doTurn(2);
        boolean res4= c.doTurn(6);
        boolean res5= c.doTurn(10);

        assertFalse(res1);
        assertFalse(res2);
        assertTrue(res3);
        assertFalse(res4);
        assertFalse(res5);



    }


}
