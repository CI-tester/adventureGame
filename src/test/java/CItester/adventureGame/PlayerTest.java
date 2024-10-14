package CItester.adventureGame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerTest {

    @Test
    void testMoveForward(){
        //Given
        Player player = new Player();
        List<Room> roomList = new ArrayList<>();
        Room room1 = mock(Room.class);
        Room room2 = mock(Room.class);
        Room room3 = mock(Room.class);
        Room room4 = mock(Room.class);

        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);
        roomList.add(room4);

        player.setCurrentRoom(room1);

        //When
        player.moveForward(roomList);


        //Then
        assertEquals(room2, player.getCurrentRoom());


    }


}