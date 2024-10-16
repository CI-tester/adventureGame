package CItester.adventureGame;

import java.util.ArrayList;
import java.util.List;

public class Room {
String colour;
boolean isDark;
Temperature temprature;
ArrayList<Item> itemsVisible;
ArrayList<Item> itemsInvisible;
boolean hasNextRoomKey;
private Room previousRoom;
private Room nextRoom;
private boolean accessible;


@Deprecated
public Room(ArrayList<Item> itemsInvisible, ArrayList<Item> itemsVisible) {
    this.itemsInvisible = itemsInvisible;
    this.itemsVisible = itemsVisible;
}


public Room(ArrayList<Item> itemsInvisible, ArrayList<Item> itemsVisible, Room previousRoom, Room nextRoom) {
    this.itemsInvisible = itemsInvisible;
    this.itemsVisible = itemsVisible;
    this.previousRoom = previousRoom;
    this.nextRoom = nextRoom;
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
public Room getNextRoom() {
        return nextRoom;
}

public void setNextRoom(Room nextRoom) {
    this.nextRoom = nextRoom;
};
public void setPreviousRoom(Room previousRoom) {
    this.previousRoom = previousRoom;
}


public boolean isAccessible() {
        return accessible;
}
}
