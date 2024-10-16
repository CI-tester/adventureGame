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

    if(item instanceof Book){

    }else if(item instanceof Key){
        if(nextRoom != null){
            nextRoom.accessible = true;
        }
    }else if(item instanceof Radiator){
        for (Item isFrozenKey: itemsVisible){
            if(isFrozenKey instanceof FrozenKey){
                itemsVisible.remove(isFrozenKey);
                ArrayList<String> interaction = new ArrayList();
                interaction.add("The door has been unlocked");
                itemsVisible.add(new Key("DoorKey",interaction));
            }
        }
    }else if(item instanceof Lightswitch){
        if(nextRoom != null){
            nextRoom.accessible = true;
        }
    }
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
public void/*String*/ getRoomDescription() { //call the Method when you enter a new room
        System.out.print(description);
        //return description
}
void setRoomDescription(String description){
    this.description = description;
} //a way to set description on a given room || use a constructor
}
