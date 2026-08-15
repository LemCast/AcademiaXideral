package game;
import characters.Player;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    //method to obtain user input from console
    public static int choices(String prompt, int userChoices){
        int input;

        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Enter an integer, please!");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }

    //method to simulate clearing out the console, adds 100 lines
    public static void clearConsole(){
        for(int i = 0; i < 100; i++)
            System.out.println();
    }

    //method to print a separator of n length
    public static void printSeparator(int n){
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //method to print a heading
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    //method to make game wait until user enters anything
    public static void pressAnything(){
        System.out.println("\nEnter any key to continue...");
        scanner.next();
    }

    //method to start the game
    public static void startGame(){
        boolean nameSet = false;
        String name;
        //printing title screen
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("Title");
        System.out.println("By Aaron Garza");
        printSeparator(30);
        printSeparator(40);
        pressAnything();

        //Getting the player's name
        do{
            clearConsole();
            printHeading("Insert a name for your character: ");
            name = scanner.next();
            //making sure if the player likes their choice
            clearConsole();
            printHeading("Your name is " + name + ".\nIs this correct?");
            System.out.println("(1) Sure!");
            System.out.println("(2) Let me choose again.");
            int choice = choices("->", 2);
            if(choice == 1)
                nameSet = true;
        }while(!nameSet);

        //initialize a new player object with given name
        player = new Player(name);

        //start main game loop
        // gameLoop();
    }
}
