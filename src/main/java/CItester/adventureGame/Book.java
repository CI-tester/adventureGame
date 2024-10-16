package CItester.adventureGame;

import java.util.List;

public class Book extends Item{

    public Book (String name, List<String> possibleInteractions) {
        super(name, possibleInteractions);

    }

    @Override
    public String onUse(){
        return "The Book have been used";
    }
}
