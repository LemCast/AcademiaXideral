package game;
import characters.Player;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    //random encounter system
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};

    //enemy names
    public static String[] enemies = {"Evil Shadow", "Zombie", "Possessed Gorilla", "Devil", "Vampire"};

    //Story elements
    public static int place = 0, act = 1;
    public static String[] places = {"Setting 1", "Setting 2", "Setting 3", "Setting 4"};

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

        //print story intro
        Story.printIntro();

        //initialize a new player object with given name
        player = new Player(name);

        //print first story act intro
        Story.printFirstActIntro();

        //setting isRunning to true so the game loop can continue
        isRunning = true;

        //start main game loop
        gameLoop();
    }

    //method that changes the game's values based on player xp
    public static void checkAct() {
        //Acts change based on player's xp
        if (player.xp >= 10 && act == 1) {
            //go into next act and setting
            act = 2;
            place = 2;
            //story flavor text
            Story.printFirstActOutro();
            //player levels up!
            player.chooseTrait();
            //into next act
            Story.printSecondActIntro();
            //assign new values to enemies
            enemies[0] = "Evil Shadow";
            enemies[1] = "Animated Skeleton";
            enemies[2] = "Chainsaw Butcher";
            enemies[3] = "Hatred Avatar";
            enemies[4] = "Banshee";
            //assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Battle";
            //fully heal player
            player.hp = player.maxHp;
        } else if (player.xp >= 50 && act == 2) {
            //go into next act and setting
            act = 3;
            place = 3;
            //story flavor text
            Story.printSecondActOutro();
            //player levels up!
            player.chooseTrait();
            //into next act
            Story.printThirdActIntro();
            //assign new values to enemies
            enemies[0] = "Evil Shadow";
            enemies[1] = "Animated Skeleton";
            enemies[2] = "Chainsaw Butcher";
            enemies[3] = "Hatred Avatar";
            enemies[4] = "Banshee";
            //assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Battle";
            //fully heal player
            player.hp = player.maxHp;
        } else if (player.xp >= 100 && act == 3) {
            //go into next act and setting
            act = 4;
            place = 4;
            //story flavor text
            Story.printThirdActOutro();
            //player levels up!
            player.chooseTrait();
            //into next act
            Story.printFourthActIntro();
            //assign new values to enemies
            enemies[0] = "Evil Shadow";
            enemies[1] = "Animated Skeleton";
            enemies[2] = "Chainsaw Butcher";
            enemies[3] = "Hatred Avatar";
            enemies[4] = "Banshee";
            //assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Battle";
            //fully heal player
            player.hp = player.maxHp;
            //calling the final battle
            //finalBattle();
        }
    }

    //method to calculate a random encounter
    public static void randomEncounter(){
        //random number between 0 and the length of the encounters array
        int encounter = (int) (Math.random()* encounters.length);
        //calling respective methods
        if(encounters[encounter].equals("Battle")){
            //randomBattle();
            } else if(encounters[encounter].equals("Rest")){
            //takeRest();
            } else {
            //shop();
        }
    }

    //method to continue the journey
    public static void continueJourney(){
        //Should act be increased?
        checkAct();
        //Is the game in the final act?
        if(act != 4)
            randomEncounter();
    }

    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " +player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp);
        printSeparator(20);

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
        printHeading(places[place]);
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
