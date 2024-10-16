package CItester.adventureGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerTest {

    private Player player;
    private Room currentRoom, previousRoom, nextRoom;

    @BeforeEach
    void setUp() {
        currentRoom = mock(Room.class);
        previousRoom = mock(Room.class);
        nextRoom = mock(Room.class);
        player = new Player(currentRoom);
    }

    @Test
    void testMoveForward() {
        when(nextRoom.isAccessible()).thenReturn(true);

        player.nextRoom = nextRoom;
        player.moveForward();

        assertEquals(nextRoom, player.getCurrentRoom());
        assertEquals(currentRoom, player.previousRoom);
        assertNull(player.nextRoom);
    }

    @Test
    void testMoveForwardNull() {
        when(nextRoom.isAccessible()).thenReturn(false);

        player.nextRoom = nextRoom;

        assertThrows(IllegalStateException.class, () -> player.moveForward());
    }

    @Test
    void testMoveBack(){
        Room room2 = mock(Room.class);
        player.moveForward();
        player.moveBack();

        assertEquals(currentRoom, player.getCurrentRoom());
    }

    @Test
    void testLookInRoom() {
        // Inga föremål i rummet
        Room emptyRoom = mock(Room.class);
        // Föremål i rummet
        Room roomWithItems = mock(Room.class);
        // Rummet har null-föremål
        Room roomNullItems = mock(Room.class);

        Item[] items = new Item[2];
        Item[] emptyItemList = new Item[0];
        Item item1 = mock(Item.class);
        Item item2 = mock(Item.class);
        items[0] = item1;
        items[1] = item2;

        Player playerEmptyRoom = new Player(emptyRoom);
        Player playerItemsInRoom = new Player(roomWithItems);
        Player playerNullItems = new Player(roomNullItems);

        when(emptyRoom.getItems()).thenReturn(emptyItemList);
        when(roomWithItems.getItems()).thenReturn(items);
        when(roomNullItems.getItems()).thenReturn(null);

        assertNull(playerNullItems.lookInRoom());
        assertArrayEquals(emptyItemList, playerEmptyRoom.lookInRoom());
        assertArrayEquals(items, playerItemsInRoom.lookInRoom());

    }

    @ParameterizedTest
    @CsvSource({
            "2,true",
            "-1,false",
            "5,false",
            "sdajk,false"
    })
    void interactWithItem(String index, boolean expected) {
        Room room = mock(Room.class);
        List<String> test = List.of("test");
        Item[] arr = {
                new Item("test", test),
                new Item("test2", test),
                new Item("test3", test)
        };
        when(room.getItems()).thenReturn(arr);
        when(room.useItem(0)).thenReturn(true);
        when(room.useItem(1)).thenReturn(true);
        when(room.useItem(2)).thenReturn(true);

        player.setCurrentRoom(room);
        boolean res = player.interactWithItem(index);
        assertEquals(expected, res);
    }

    @DisplayName("Testar om spelaren kan gå tillbaka när föregående rum är tillgängligt")
    @Test
    void testCanMoveBackWhenPreviousRoomIsAccessible() {
        when(currentRoom.getPreviousRoom()).thenReturn(previousRoom);
        when(previousRoom.isAccessible()).thenReturn(true);

        assertTrue(player.canMoveBack(), "Player should be able to move back when previous room is accessible.");
    }
}
