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

    private Player player;
    private Room currentRoom, previousRoom;

    @BeforeEach
    void setUp() {
        currentRoom = mock(Room.class);
        previousRoom = mock(Room.class);
        player = new Player(currentRoom);
    }

    @Test
    public void boolTest(){
        Main main = new Main();
        boolean isb = main.isBool();

        assertEquals(isb, true);
    }

    @DisplayName("Testar om spelaren kan gå tillbaka när föregående rum är tillgängligt")
    @Test
    void testCanMoveBackWhenPreviousRoomIsAccessible() {
        when(currentRoom.getPreviousRoom()).thenReturn(previousRoom);
        when(previousRoom.isAccessible()).thenReturn(true);

        assertTrue(player.canMoveBack(), "Player should be able to move back when previous room is accessible.");
    }
}
