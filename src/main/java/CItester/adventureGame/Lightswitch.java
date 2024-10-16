package CItester.adventureGame;

import java.util.List;

public class Lightswitch extends Item{

    public Lightswitch (String name, List<String> possibleInteractions) {
        super(name, possibleInteractions);

    }

    @Override
    public String onUse(){
        return "You flip the lightswitch";
    }
}
