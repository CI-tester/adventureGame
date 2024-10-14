package CItester.adventureGame;

import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);
    boolean running = true;
    public void printInfo(){
        System.out.println("Vad vill ni göra:" +
                "\n1. Gå till nästa rum" +
                "\n2. Gå till föregående rum" +
                "\n3. Titta i rummet" +
                "\n4. Interagera med ett föremål" +
                "\n5. Avsluta Spelet");
    }
    public boolean doTurn(int choice){
        return false;
    }
    public void runGame(){
        while (running){
            printInfo();
            int choice = scanner.nextInt();
            doTurn(choice);
        }


    }
}
