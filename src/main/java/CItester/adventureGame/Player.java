package CItester.adventureGame;

import java.util.List;

public class Player {

    private Room currentRoom;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
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
}
