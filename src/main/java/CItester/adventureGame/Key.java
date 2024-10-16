package CItester.adventureGame;

import java.util.List;

public class Key extends Item{

    public Key (String name, List<String> possibleInteractions) {
        super(name, possibleInteractions, false);

    }

    @Override
   public String onUse(){
        return "The key have been used";
    }
}
