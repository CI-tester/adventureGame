package CItester.adventureGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerTest {

    @ParameterizedTest
    @CsvSource({
            "2,true",
            "-1,false",
            "5,false"
    })
    void interactWithItem(int index, boolean expected) {
        //given
        Room room = mock(Room.class);
        List<String> test = List.of("test");
        Item[] arr = {new Item("test", test),
                    new Item("test2", test),
                    new Item("test3", test)};
        when(room.getItems()).thenReturn(arr);

        when(room.useItem(0)).thenReturn(true);
        when(room.useItem(1)).thenReturn(true);
        when(room.useItem(2)).thenReturn(true);
        //when
        boolean res = room.useItem(index);
        //then
        assertEquals(expected, res);
    }
}