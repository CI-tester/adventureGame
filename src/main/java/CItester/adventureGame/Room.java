package CItester.adventureGame;

import java.util.ArrayList;

public class Room {
String colour;
boolean isDark;
Temperature temprature;
ArrayList<Item> itemsVisible;
ArrayList<Item> itemsInvisible;
boolean hasNextRoomKey;

public Room(ArrayList<Item> itemsInvisible, ArrayList<Item> itemsVisible) {
    this.itemsInvisible = itemsInvisible;
    this.itemsVisible = itemsVisible;
}

public Item[] getItems(){
    if(itemsVisible.isEmpty()) return null;
    return itemsVisible.toArray(new Item[0]);
}
public boolean useItem(int index){
    if(index < 0 || index >= itemsVisible.size()){
        throw new IndexOutOfBoundsException();
    }
    Item item = itemsVisible.get(index);
    if(item == null) return false;


    String itemUse = item.onUse();
    System.out.println(itemUse);
    return true;
}

}
enum Temperature {
    low,medium,high
}
