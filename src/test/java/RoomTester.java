import CItester.adventureGame.Item;
import CItester.adventureGame.Room;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoomTester {

    @Test
    @DisplayName("Testa att spelaren ser endast lysande föremål i mörker och alla föremål när ljuset är på")
    void testLookAroundWhenRoomIsDarkAndLightSwitchIsUsed() {
        // Given: Vi har ett mörkt rum och två föremål - ett som lyser i mörker och ett som inte gör det
        Room room = new Room(new ArrayList<>(), new ArrayList<>());
        room.isDark = true;  // Sätt rummet till mörkt

        // Hardkodade items
        Item glowingItem = mock(Item.class);
        when(glowingItem.isGlowing()).thenReturn(true);  // Detta föremål lyser i mörker
        when(glowingItem.onUse()).thenReturn("You used the glowing item.");

        Item normalItem = mock(Item.class);  // Ett föremål som inte kan ses i mörker
        when(normalItem.isGlowing()).thenReturn(false);  // Detta föremål lyser inte i mörker

        // Lägg till glowingItem till synliga föremål i rummet
        room.itemsVisible.add(glowingItem);

        // Lägg till normalItem till osynliga föremål som bara syns när ljuset är på
        room.itemsInvisible.add(normalItem);

        // When: Spelaren kollar sig runt i rummet medan det är mörkt
        Item[] visibleItemsInDark = room.lookAround();

        // Then: Endast föremål som lyser i mörker ska vara synliga
        assertArrayEquals(new Item[]{glowingItem}, visibleItemsInDark);

        // When: Spelaren använder ljusströmbrytaren och rummet blir ljust
        room.isDark = false;

        // Eftersom ljuset är tänt nu, bör alla föremål vara synliga
        room.itemsVisible.add(normalItem);  // Flytta normalItem till synliga föremål när ljuset är på

        // When: Spelaren kollar sig runt efter att ljuset har tänts
        Item[] visibleItemsInLight = room.lookAround();

        // Then: Alla föremål ska vara synliga i ljuset
        assertArrayEquals(new Item[]{glowingItem, normalItem}, visibleItemsInLight);
    }


    @Test
    void getItemsTest() {
        Item item1 = mock(Item.class);
        Item item2 = mock(Item.class);
        Item item3 = mock(Item.class);
        when(item1.toString()).thenReturn("Item 1");
        when(item2.toString()).thenReturn("Item 2");
        when(item3.toString()).thenReturn("Item 3");

        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Item> items2 = new ArrayList<Item>();
        items2.add(item1);
        items2.add(item2);
        items2.add(item3);


        //No Array
        Room room = new Room(null, null);
        //Empty Array
        Room room2 = new Room(null, items);
        //Items in array
        Room room3 = new Room(null, items2);


        //assertThrows(NullPointerException.class, room::getItems);
        assertNull(room2.getItems());
        assertArrayEquals(items2.toArray(new Item[0]), room3.getItems());


    }

    @Test
    void useItem() {

        Item item1 = mock(Item.class);
        Item item2 = null;
        Item item3 = mock(Item.class);
        when(item1.toString()).thenReturn("Item 1");
        when(item3.toString()).thenReturn("Item 3");

        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Item> items2 = new ArrayList<Item>();
        items2.add(item1);
        items2.add(item2);
        items2.add(item3);


        //No Array
        Room room = new Room(null, null);
        //Empty Array
        Room room2 = new Room(null, items);
        //Items in array
        Room room3 = new Room(null, items2);


        //IndexToLow
        assertThrows(IndexOutOfBoundsException.class, () -> {
            room2.useItem(-5);
        });
        //IndexToHigh
        assertThrows(IndexOutOfBoundsException.class, () -> {
            room2.useItem(15);
        });
        //ItemNull
        assertFalse(room3.useItem(1));
        //ArrayNull
        //assertThrows(NullPointerException.class, ()->{room.useItem(2);});
        //ItemWorks
        assertTrue(room3.useItem(0));
    }
}
