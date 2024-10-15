package CItester.adventureGame;

import java.util.ArrayList;

public class Player {
    ArrayList<Item> items;

    Player(ArrayList<Item> listOfItems){
        items = listOfItems;
    }

    String interactWithItem(String itemName){
        for (Item item : items) {
            if (item.equals(itemName)){
                return item.onUse();
            }
        }
        return null;
    }
}
