package CItester.adventureGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Room currentRoom;
    Room previousRoom;
    Room nextRoom;
    Scanner scan = new Scanner(System.in);
  
     public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public boolean interactWithItem(){
        int index = -1;
        Item[] itemList = currentRoom.getItems();
        System.out.println("items: ");
        for (int i = 0; i < itemList.length; i++) {
            System.out.println("index: " + i + "item name: " + itemList[i]);
        }
        System.out.println("with index?");
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
        return this.previousRoom != null && this.previousRoom.isAccessible();
    }

    public void moveBack(){
        if (!canMoveBack()) {
            throw new IllegalStateException("Cannot move back");
        } else {
            this.nextRoom = this.currentRoom;
            setCurrentRoom(this.previousRoom);
            this.previousRoom = null;
        }
    }

    public boolean canMoveForward() {
        return this.nextRoom != null && this.nextRoom.isAccessible();
    }


    public void moveForward() {
        if (!canMoveForward()) {
            throw new IllegalStateException("Cannot move forward");
        }
        else {
            this.previousRoom = this.currentRoom;
            setCurrentRoom(this.nextRoom);
            this.nextRoom = null;
        }
    }


    public void setCurrentRoom(Room room) {
        this.currentRoom = room;

    }

    public Room getCurrentRoom() {
        return currentRoom;

    }

    public Item[] lookInRoom() {
        return this.currentRoom.getItems();

    }
}
