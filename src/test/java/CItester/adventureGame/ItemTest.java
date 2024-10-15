package CItester.adventureGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemTest {

    @Test
    void getItemName() {
        Item item = new Item("Book", Arrays.asList("Use", "Inspect"));
        assertEquals("Book", item.getItemName());
    }

    @Test
    void getPossibleInteractions() {
        List<String> expectedInteractions = Arrays.asList("Use", "Drop");
        Item item = new Item("Key", expectedInteractions);
        assertEquals(expectedInteractions, item.getPossibleInteractions());
    }

    @Test
    void onUse() {
        Item item = new Item("Key", Arrays.asList("Use", "Inspect"));
        assertEquals("You have used the " + item.getItemName() + " item!", item.onUse() );
    }

    //Parametriserade tester
    @ParameterizedTest
    @CsvSource({
            "Book, You have used the Book item!",
            "Key, You have used the Key item!",
            "Torch, You have used the Torch item!"
    })

    void parameterizedItemTest(String itemName, String expectedItemMessage) {
        Item item = new Item(itemName, Arrays.asList("Use", "Inspect"));
        assertEquals(expectedItemMessage, item.onUse());
    }

    //Mocking
   /* @Test
    void itemMockingTest(){
        Room mokcRoom = mock(Room.class);

        Item item = new Item("Key", Arrays.asList("Use", "Inspect"));

        when(mokcRoom.interactWithItem(item)).thenReturn("Door unlocked!");

        assertEquals("Door unlocked!", mokcRoom.interactWithItem(item));

        verify(mokcRoom, times(1)).interactWithItem(item);
    }*/

}