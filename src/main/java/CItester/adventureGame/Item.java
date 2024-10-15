package CItester.adventureGame;

public class Item {
    String itemName;
    String onUse(){
        //Use item
        return "";
    }

    boolean equals(String name){
        return itemName.equalsIgnoreCase(name);
    }
}
