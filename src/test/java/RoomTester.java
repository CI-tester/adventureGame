import CItester.adventureGame.Item;
import CItester.adventureGame.Room;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoomTester {



    @Test
    void getItemsTest(){
        //Given
        Item item = mock(Item.class);
        when(item.toString()).thenReturn("Item 1");

        ArrayList<Item> itemsEmpty = new ArrayList<Item>();
        ArrayList<Item> items2 = new ArrayList<Item>();
        items2.add(item);
        items2.add(item);

        //When
        //No Array
        Room room = new Room(null,null);
        //Empty Array
        Room room2 = new Room(null,itemsEmpty);
        //Items in array
        Room room3 = new Room(null,items2);


        //Then
        assertThrows(NullPointerException.class, room::getItems);
        assertNull(room2.getItems());
        assertArrayEquals(items2.toArray(new Item[0]), room3.getItems());


    }
    @Test
    void useItem(){
        //Given
        Item item1 = mock(Item.class);
        when(item1.toString()).thenReturn("Item 1");
        ArrayList<Item> itemsEmpty = new ArrayList<Item>();
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(null);


        //When
        //No Array
        Room room = new Room(null,null);
        //Empty Array
        Room room2 = new Room(null,itemsEmpty);
        //Items in array
        Room room3 = new Room(null,items);


        //Then
        //IndexToLow
        assertThrows(IndexOutOfBoundsException.class, ()->{room2.useItem(-5);});
        //IndexToHigh
        assertThrows(IndexOutOfBoundsException.class, ()->{room2.useItem(15);});
        //ItemNull
        assertFalse(room3.useItem(1));
        //ArrayNull
        assertThrows(NullPointerException.class, ()->{room.useItem(2);});
        //ItemWorks
        assertTrue(room3.useItem(0));
    }



}
