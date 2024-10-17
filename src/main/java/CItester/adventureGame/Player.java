package CItester.adventureGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Room currentRoom;
    Scanner scan = new Scanner(System.in);
  
     public Player(Room startingRoom) {
         setCurrentRoom(startingRoom);
     //this.currentRoom = startingRoom;
    }

    public boolean interactWithItem(){
        int index = -1;
        Item[] itemList = currentRoom.getItems();
        System.out.println("Saker: ");
        if(itemList.length == 0) return false;
        for (int i = 0; i < itemList.length; i++) {
            System.out.println(i + ":  " + itemList[i]);
        }
        System.out.println("Välj ett index");
        try {
            index = Integer.parseInt(scan.next());
            return currentRoom.useItem(index);
        }
        catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean interactWithItem(String testIndex){//for testing
        int index = -1;
        try {
            index = Integer.parseInt(testIndex);
            return currentRoom.useItem(index);
        }
        catch (NumberFormatException e) {
            return false;
        }
     }


    public boolean canMoveBack() {
        return this.currentRoom.getPreviousRoom() != null && this.currentRoom.getPreviousRoom().isAccessible();
    }

    public void moveBack(){
        if (!canMoveBack()) {
            throw new IllegalStateException("Cannot move back");
        } else {
            setCurrentRoom(this.currentRoom.getPreviousRoom());
        }
    }

    public boolean canMoveForward() {
        return this.currentRoom.getNextRoom() != null && this.currentRoom.getNextRoom().isAccessible();
    }


    public void moveForward() {
        if (!canMoveForward()) {
            throw new IllegalStateException("Cannot move forward");
        }
        else {
            setCurrentRoom(this.currentRoom.getNextRoom());
        }
    }


    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
        System.out.println(room.getRoomDescription());
    }


    public Room getCurrentRoom() {
        return currentRoom;

    }

    public Item[] lookInRoom() {
        return this.currentRoom.getItems();

    }
}
