package CItester.adventureGame;

import java.util.ArrayList;
import java.util.List;

public class Room {

private String description;
String colour;
boolean isDark;
Temperature temprature;
ArrayList<Item> itemsVisible;
ArrayList<Item> itemsInvisible;
boolean hasNextRoomKey;
private Room previousRoom;
private boolean accessible;


public Room(ArrayList<Item> itemsInvisible, ArrayList<Item> itemsVisible) {
    this.itemsInvisible = itemsInvisible;
    this.itemsVisible = itemsVisible;
}
  
enum Temperature {
    low,medium,high}

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


public Room getPreviousRoom() {
        return previousRoom;
}

public boolean isAccessible() {
        return accessible;
}
public void/*String*/ getRoomDescription() { //call the Method when you enter a new room
        System.out.print(description);
        //return description
}
void setRoomDescription(String description){
    this.description = description;
} //a way to set description on a given room || use a constructor
}
