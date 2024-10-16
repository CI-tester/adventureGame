package CItester.adventureGame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Room[] rooms = setUpRooms();
        int index = 0;
        Player p = new Player(rooms[0]);
        Console c = new Console(p,rooms);
        c.runGame();
    }

    public static Room[] setUpRooms(){
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(new ArrayList<>(),new ArrayList<>()));
        rooms.add(new Room(new ArrayList<>(),new ArrayList<>()));
        rooms.add(new Room(new ArrayList<>(),new ArrayList<>()));
        return rooms.toArray(new Room[0]);
    }


    public boolean isBool(){
        return true;
    }

}