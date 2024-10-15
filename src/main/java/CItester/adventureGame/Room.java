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
    return null;
}
public boolean useItem(int index){
    return false;
}

}
enum Temperature {
    low,medium,high
}
