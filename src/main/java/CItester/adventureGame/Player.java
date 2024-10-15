package CItester.adventureGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Room curentRoom;
    Scanner scan = new Scanner(System.in);

    boolean interactWithItem(/*int testIndex*/){
        int index = -1;
        Item[] itemList = curentRoom.getItems();
        System.out.println("items: ");
        for (int i = 0; i < itemList.length; i++) {
            System.out.println("index: " + i + "item name: " + itemList[i]);
        }
        System.out.println("index?");
        index = scan.nextInt();
        return curentRoom.useItem(index);
        //return curentRoom.useItem(testIndex);
    }
}
