package CItester.adventureGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemSubclassesTest {

    @Test
    void keyTest(){
        //given
        Key key = new Key("Key", Arrays.asList("Use", "Inspekt"));
        //When
        String result = key.onUse();
        //Then
        assertEquals("The key have been used, The door is unlocked! ", result);
    }

    @Test
    void lightswitch(){
        //given
        Lightswitch lightswitch = new Lightswitch("Lightswitch", Arrays.asList("Use", "Inspekt"));
        //When
        String result = lightswitch.onUse();
        //Then
        assertEquals("You flip the lightswitch, the room is now illuminated! ", result);
    }

    @Test
    void frozenKey(){
        //given
        FrozenKey frozenKey = new FrozenKey("Frozen Key", Arrays.asList("Use", "Inspekt"));
        //When
        String result = frozenKey.onUse();
        //Then
        assertEquals("The key is frozen, you need to thaw it first!", result);
    }

    @Test
    void Radiator(){
        //given
        Radiator radiator = new Radiator("Radiator", Arrays.asList("Use", "Inspekt"));
        //When
        String result = radiator.onUse();
        //Then
        assertEquals("You turn the radiator. The room starts to warm up.", result);
    }

    //ParameterizedTest
    @ParameterizedTest
    @CsvSource({
            "Key,The key have been used",
            "Lightswitch,You flip the lightswitch",
            "Frozen Key,The key is frozen",
            "Radiator,You turn the radiator. The room starts to warm up.",
    })

    void itemSubClassesParameterizedTest(String itemName, String expectedResult){
        //Given

        Item item ;
        switch (itemName){
            case "Key":
                item = new Key(itemName, Arrays.asList("Use", "Inspekt"));
                break;
            case  "Lightswitch":
                item = new Lightswitch(itemName, Arrays.asList("Use", "Inspekt"));
                break;
            case "Frozen Key":
                item = new FrozenKey(itemName, Arrays.asList("Use", "Inspekt"));
                break;
            case "Radiator":
                item = new Radiator(itemName, Arrays.asList("Use", "Inspekt"));
                break;
            default: throw new IllegalArgumentException("Invalid item name: " + itemName);
        };

        //When
        String result = item.onUse();

        //Then
        assertEquals(expectedResult, result);

    }
}
