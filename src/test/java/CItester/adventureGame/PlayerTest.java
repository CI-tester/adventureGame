package CItester.adventureGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerTest {

    @ParameterizedTest
    @CsvSource({
            "door,Use item",
            "test,",
            "s,",
            "window,Use item"
    })
    void interactWithItem(String testItem, String expected) {
        //given
        Item item1 = mock(Item.class);
        Item item2 = mock(Item.class);
        Item item3 = mock(Item.class);
        Item item4 = mock(Item.class);

        when(item1.equals("door")).thenReturn(true);
        when(item1.onUse()).thenReturn("Use item");

        when(item2.equals("char")).thenReturn(true);
        when(item2.onUse()).thenReturn("Use item");

        when(item3.equals("window")).thenReturn(true);
        when(item3.onUse()).thenReturn("Use item");

        when(item4.equals("lamp")).thenReturn(true);
        when(item4.onUse()).thenReturn("Use item");

        ArrayList<Item> arr = new ArrayList<>();
        arr.add(item1);
        arr.add(item2);
        arr.add(item3);
        arr.add(item4);

        Player playtest = new Player(arr);
        //when
        String answer = playtest.interactWithItem(testItem);

        //then
        assertEquals(expected, answer);
    }
}