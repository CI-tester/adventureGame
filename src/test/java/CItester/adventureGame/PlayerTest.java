package CItester.adventureGame;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

class PlayerTest {

    @Test
    void testMoveForward(){
        Room room1 = mock(Room.class);
        Room room2 = mock(Room.class);
        Player player = new Player(room1);

        player.moveForward(room2);

        assertEquals(room2, player.getCurrentRoom());
    }

    @Test
    void testMoveForwardNull(){
        Room room1 = mock(Room.class);
        Player player = new Player(room1);

        assertThrows(NullPointerException.class,
                () -> player.moveForward(null));

    }

    @Test
    void testLookInRoom(){
        //No items in room
        Room emptyRoom = mock(Room.class);
        //Items in room
        Room roomWithItems = mock(Room.class);
        //Null items in room
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


        assertNull(playerNullItems.lookInRoom(roomNullItems));
        assertArrayEquals(emptyItemList, playerEmptyRoom.lookInRoom(emptyRoom));
        assertArrayEquals(items, playerItemsInRoom.lookInRoom(roomWithItems));


    }
  
      @ParameterizedTest
    @CsvSource({
            "2,true",
            "-1,false",
            "5,false",
            "sdajk,false"
    })
    void interactWithItem(String index, boolean expected) {
        //given
        Player playTest = new Player();
        Room room = mock(Room.class);
        List<String> test = List.of("test");
        Item[] arr = {new Item("test", test),
                    new Item("test2", test),
                    new Item("test3", test)};
        when(room.getItems()).thenReturn(arr);

        when(room.useItem(0)).thenReturn(true);
        when(room.useItem(1)).thenReturn(true);
        when(room.useItem(2)).thenReturn(true);

        playTest.curentRoom = room;
        //when
        boolean res = playTest.interactWithItem(index);
        //then
        assertEquals(expected, res);
    }
}