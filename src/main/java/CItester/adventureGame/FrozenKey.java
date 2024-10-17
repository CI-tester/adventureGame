package CItester.adventureGame;

import java.util.List;

public class FrozenKey extends Item{

    public FrozenKey (String name, List<String> possibleInteractions) {
        super(name, possibleInteractions);

    }

    @Override
    public String onUse(){
        return "The key is frozen";
    }
}
