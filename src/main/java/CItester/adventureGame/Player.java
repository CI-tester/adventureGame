package CItester.adventureGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Room curentRoom;
    Scanner scan = new Scanner(System.in);
  
     public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public boolean interactWithItem(){
        int index = -1;
        Item[] itemList = curentRoom.getItems();
        System.out.println("items: ");
        for (int i = 0; i < itemList.length; i++) {
            System.out.println("index: " + i + "item name: " + itemList[i]);
        }
        System.out.println("with index?");
        try {
            index = Integer.parseInt(scan.next());
            return curentRoom.useItem(index);
        }
        catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean interactWithItem(String testIndex){//for testing
        int index = -1;
        try {
            index = Integer.parseInt(testIndex);
            return curentRoom.useItem(index);
        }
        catch (NumberFormatException e) {
            return false;
        }
      
 

    public boolean canMoveBack() {
        Room previousRoom = currentRoom.getPreviousRoom();
        return previousRoom != null && previousRoom.isAccessible();
    }
    public void moveForward(Room nextRoom) {
        if (nextRoom == null) {
            throw new NullPointerException();
        }
        setCurrentRoom(nextRoom);
    }


    public void setCurrentRoom(Room room) {
        this.currentRoom = room;

    }

    public Room getCurrentRoom() {
        return currentRoom;

    }

    public Item[] lookInRoom(Room room) {
        return (Item[]) room.getItems();

    }
}
