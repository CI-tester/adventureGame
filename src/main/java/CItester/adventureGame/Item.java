package CItester.adventureGame;

import java.util.List;

public class Item {
    private String itemName;
    private List<String> possibleInteractions;
    protected boolean canGlowInDark;

    public Item(String itemName, List<String> possibleInteractions, boolean canGlowInDark) {
        this.itemName = itemName;
        this.possibleInteractions = possibleInteractions;
        this.canGlowInDark = canGlowInDark;
    }

    public String getItemName() {
        return itemName;
    }

    public List<String> getPossibleInteractions() {
        return possibleInteractions;
    }

    public String onUse(){
        return "You have used the " + itemName + " item!";
    }

    public boolean isGlowing() {
        return canGlowInDark; // Returnera värdet av egenskapen
    }
}
