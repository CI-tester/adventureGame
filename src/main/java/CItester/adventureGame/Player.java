package CItester.adventureGame;

public class Player {
    private Room currentRoom;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public boolean canMoveBack() {
        Room previousRoom = currentRoom.getPreviousRoom();
        return previousRoom != null && previousRoom.isAccessible();
    }
}
