package CItester.adventureGame;

import java.util.List;

public class Radiator extends Item{

    public Radiator (String name, List<String> possibleInteractions) {
        super(name, possibleInteractions, false);

    }

    @Override
    public String onUse(){
        return "You turn the radiator. The room starts to warm up.";
    }
}
