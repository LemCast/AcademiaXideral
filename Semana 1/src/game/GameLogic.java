package game;
import characters.Player;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

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
        System.out.println("Spire Top");
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

        //setting isRunning to true so the game loop can continue
        isRunning = true;

        //start main game loop
        gameLoop();
    }

    //method to continue the journey
    public static void continueJourney(){

    }

    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " +player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp);

        //printing chosen traits
        if(player.numAtkUpgrades > 0){
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Defensive trait" + player.defUpgrades[player.numDefUpgrades - 1]);
        }

        pressAnything();
    }

    //printing the main menu
    public static void printMenu(){
        clearConsole();
        printHeading("MENU");
        System.out.println("Choose an action: ");
        printSeparator(20);
        System.out.println("(1) Continue on the journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }

    //main game loop
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = choices("->", 3);
            if(input == 1)
                continueJourney();
            else if(input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }

}
