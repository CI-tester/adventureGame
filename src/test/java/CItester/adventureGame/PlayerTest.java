package CItester.adventureGame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PlayerTest {

    @Test
    void testMoveForward(){
        //Given
        Room room1 = mock(Room.class);
        Room room2 = mock(Room.class);
        Player player = new Player(room1);


        //When
        player.moveForward(room2);


        //Then
        assertEquals(room2, player.getCurrentRoom());
    }

    @Test
    void testMoveForwardNull(){
        //Given
        Room room1 = mock(Room.class);
        Player player = new Player(room1);

        //When


        //Then
        assertThrows(NullPointerException.class,
                () -> player.moveForward(null));

    }

}