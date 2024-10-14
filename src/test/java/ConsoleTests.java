import CItester.adventureGame.Console;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsoleTests {

    @Test
    void doTurnTests(){
        Console c = new Console();

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
