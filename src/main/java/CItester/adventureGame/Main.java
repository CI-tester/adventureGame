package CItester.adventureGame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Room firstRoom = setUpRooms();
        int index = 0;
        Player p = new Player(firstRoom);
        Console c = new Console(p);
        c.runGame();
    }

    public static Room setUpRooms(){
        Room r1 = new Room(new ArrayList<>(),new ArrayList<>());
        Room r2 = new Room(new ArrayList<>(),new ArrayList<>());
        Room r3 = new Room(new ArrayList<>(),new ArrayList<>());
        Room r4 = new Room(new ArrayList<>(),new ArrayList<>());

       r1.setNextRoom(r2);
       r2.setNextRoom(r3);
       r3.setNextRoom(r4);
       r4.setPreviousRoom(r3);
       r3.setPreviousRoom(r2);
       r2.setPreviousRoom(r1);


        return r1;
    }


    public boolean isBool(){
        return true;
    }

}