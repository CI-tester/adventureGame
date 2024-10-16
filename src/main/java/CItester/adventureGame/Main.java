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


        ArrayList<Item> room1Items = new ArrayList<Item>();
        ArrayList<String> room1Item1Interaction = new ArrayList<String>();
        room1Item1Interaction.add("Du slår på lampan och ser dörren till nästa rum");
        room1Items.add(new Lightswitch("Lightswitch",room1Item1Interaction));
        Room r1 = new Room(new ArrayList<>(),room1Items);

        ArrayList<Item> room2Items = new ArrayList<Item>();
        ArrayList<String> room2Item1Interaction = new ArrayList<String>();
        room2Item1Interaction.add("Du ser nycken till dörren i ett isblock men kan inte få ut den och undrar om de finns något sätt");
        room2Items.add(new FrozenKey("Fryst Nyckel",room1Item1Interaction));
        ArrayList<String> room2Item2Interaction = new ArrayList<String>();
        room2Item2Interaction.add("Du ser ett element och slår på de ");
        room2Items.add(new Radiator("Element",room2Item2Interaction));

        ArrayList<Item> room2ItemsInvisable = new ArrayList<Item>();
        ArrayList<String> room2Item3Interaction = new ArrayList<String>();
        room2Item3Interaction.add("Nyckeln har tinat och används för att öppna dörren");
        room2ItemsInvisable.add(new Radiator("Dörr nyckel",room2Item3Interaction));

        Room r2 = new Room(room2ItemsInvisable,room2Items);
        Room r3 = new Room(new ArrayList<>(),new ArrayList<>());
        Room r4 = new Room(new ArrayList<>(),new ArrayList<>());

        r1.setRoomDescription("Mörkt rum, leta runt för att hitta en lightswitch," +
                " Interagera med den för att tända rummet " +
                "och därmed se dörren för att komma vidare ");

        r2.setRoomDescription("Kallt rum, man ser en nyckel i ett isblock, " +
                "använd radiatorn för att smälta isblocket och " +
                "kunna låsa upp dörren för att komma vidare");

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