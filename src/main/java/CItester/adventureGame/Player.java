package CItester.adventureGame;

import java.util.List;

public class Player {


    private List<Room> roomList;
    private Room currentRoom;


    public void moveForward(List<Room> roomList) {
        int currentRoomIndex = roomList.indexOf(currentRoom);
        int nextRoomIndex = currentRoomIndex + 1;

        if (nextRoomIndex < roomList.size())
        {
            setCurrentRoom(roomList.get(nextRoomIndex));
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

    }


    public void setCurrentRoom(Room room) {
        this.currentRoom = room;

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
