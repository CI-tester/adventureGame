package CItester.adventureGame;

import java.util.List;

public class Item {
    private String itemName;
    private List<String> possibleInteractions;

    public Item(String itemName, List<String> possibleInteractions) {
        this.itemName = itemName;
        this.possibleInteractions = possibleInteractions;
    }

    public String getItemName() {
        return itemName;
    }

    public List<String> getPossibleInteractions() {
        return possibleInteractions;
    }

    public String onUse(){
        return "Du har använt " + itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }
}
