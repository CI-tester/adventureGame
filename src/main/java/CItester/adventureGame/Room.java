package CItester.adventureGame;

public class Room {
    private Room previousRoom;
    private boolean accessible;

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public boolean isAccessible() {
        return accessible;
    }
}
