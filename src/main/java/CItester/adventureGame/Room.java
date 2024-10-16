package CItester.adventureGame;

import java.util.ArrayList;
import java.util.List;

public class Room {
    String colour;
    Temperature temprature;
    public ArrayList<Item> itemsVisible;
    public ArrayList<Item> itemsInvisible;
    boolean hasNextRoomKey;
    private Room previousRoom;
    private boolean accessible;

    public boolean isDark;

    public Room(ArrayList<Item> itemsInvisible, ArrayList<Item> itemsVisible) {
        this.itemsInvisible = (itemsInvisible == null) ? new ArrayList<>() : itemsInvisible;
        this.itemsVisible = (itemsVisible == null) ? new ArrayList<>() : itemsVisible;
    }

    public Item[] lookAround() {
        // Om rummet är mörkt, returnera bara föremål som kan lysa i mörker
        if (isDark) {
            List<Item> glowingItems = new ArrayList<>();
            for (Item item : itemsVisible) {
                if (item.isGlowing()) {  // Kontrollera om föremålet kan lysa i mörker
                    glowingItems.add(item);
                }
            }
            return glowingItems.isEmpty() ? new Item[0] : glowingItems.toArray(new Item[0]);
        }

        // Om rummet inte är mörkt, returnera alla synliga föremål
        return itemsVisible.isEmpty() ? new Item[0] : itemsVisible.toArray(new Item[0]);
    }


    enum Temperature {
        low, medium, high
    }

    public Item[] getItems() {
        if (itemsVisible.isEmpty()) return null;
        return itemsVisible.toArray(new Item[0]);
    }

    public boolean useItem(int index) {
        if (index < 0 || index >= itemsVisible.size()) {
            throw new IndexOutOfBoundsException();
        }
        Item item = itemsVisible.get(index);
        if (item == null) return false;


        String itemUse = item.onUse();
        System.out.println(itemUse);
        return true;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public boolean isAccessible() {
        return accessible;
    }
}
