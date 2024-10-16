package CItester.adventureGame;

import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    public Console(Player p) {
        this.p = p;
    }

    Player p;
    int roomIndex = 0;

    public void printInfo(){
        System.out.println("Vad vill ni göra:" +
                "\n1. Gå till nästa rum" +
                "\n2. Gå till föregående rum" +
                "\n3. Titta i rummet" +
                "\n4. Interagera med ett föremål" +
                "\n5. Avsluta Spelet");
    }
    public boolean doTurn(int choice){
        switch (choice){
            case 1:
                if(p.canMoveForward()){
                     p.moveForward();
                }else System.out.println("Kan inte gå framåt");

                break;
            case 2:
                if(p.canMoveBack()){
                    p.moveBack();
                }else System.out.println("Kan inte gå bakåt");
                break;
            case 3:
                Item[] items = p.lookInRoom();
                 if(items.length == 0){
                     System.out.println("There are no visable items in the room");
                }
                System.out.println("You have the following objects in the room:");
                for (Item item : items) {
                    System.out.println("\n"+item);
                }
                break;
            case 4:
                p.interactWithItem();
                break;
            case 5:
                running = false;
                break;
            default:
                return false;
        }
        return true;
    }
    public void runGame(){
        while (running){
            printInfo();
            int choice = scanner.nextInt();
            doTurn(choice);
        }


    }
}
