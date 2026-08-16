package game;
import characters.Enemy;
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
        if (player.getXp() >= 10 && act == 1) {
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
            player.fullHeal();
        } else if (player.getXp() >= 50 && act == 2) {
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
            player.fullHeal();
        } else if (player.getXp() >= 100 && act == 3) {
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
            player.fullHeal();
            //calling the final battle
            finalBattle();
        }
    }

    //method to calculate a random encounter
    public static void randomEncounter(){
        //random number between 0 and the length of the encounters array
        int encounter = (int) (Math.random()* encounters.length);
        //calling respective methods
        if(encounters[encounter].equals("Battle")){
            randomBattle();
            } else if(encounters[encounter].equals("Rest")){
            takeRest();
            } else {
            shop();
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
        System.out.println(player.getName() + "\tHP: " +player.getHp() + "/" + player.getMaxHp());
        printSeparator(20);
        //player xp and gold
        System.out.println("XP: " + player.getXp() + "\tGold: " + player.gold);
        printSeparator(20);
        //# of pots
        System.out.println("# of Potions: " + player.potions);
        printSeparator(20);

        //printing chosen traits
        if(player.numAtkUpgrades > 0){
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }

        pressAnything();
    }

    //encountering traveling merchant
    public static void shop(){
        clearConsole();
        printHeading("You meet a mysterious stranger.\nHe offers you something: ");
        int price = (int) (Math.random()* (10 + player.potions*3) + 10 + player.potions);
        System.out.println("- Healing Potion: " + price + " gold.");
        printSeparator(20);
        //does the player want to buy one?
        System.out.println("Do you want to buy one?\n(1) Sure do!\n(2)No thanks.");
        int input = choices("->", 2);
        //check user input
        if(input == 1){
            clearConsole();
            //check if player has enough gold
            if(player.gold >= price){
                printHeading("You bought a Healing Potion for " + price + " gold!");
                player.potions++;
                player.gold -= price;
            }else
                printHeading("Not enough cash, stranger!");
            pressAnything();
        }
    }

    //taking a rest
    public static void takeRest(){
        clearConsole();
        if(player.restsLeft >= 1){
            printHeading("Do you want to take a rest? You have " + player.restsLeft + " left.");
            System.out.println("(1) Let's get some rest\n(2)I'm good for now.");
            int input = choices("->", 2);
            if(input == 1){
                //player rests
                clearConsole();
                if(player.getHp() < player.getMaxHp()){
                    player.restHealHp(player.getHp());
                    if(player.getHp() > player.getMaxHp())
                        player.fullHeal();
                    System.out.println("After some well-deserved rest, you recover some HP.");
                    System.out.println("You now have " + player.getHp() + "/" + player.getMaxHp() + " HP.");
                    player.restsLeft--;
                }else
                    System.out.println("You are at full health. Rest is not needed, you are good to go!");
                pressAnything();
            }
        }
    }

    //creating a random battle
    public static void randomBattle(){
        clearConsole();
        printHeading("An evil entity approaches! Time for a battle!");
        pressAnything();
        //creating new enemy with random name
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.getXp()));
    }

    //the main battle method
    public static void battle(Enemy enemy){
        //main battle loop
        while(true){
            clearConsole();
            printHeading(enemy.getName() + "\nHP: " + enemy.getHp() + "/" + enemy.getMaxHp());
            printHeading(player.getName() + "\nHP: " + player.getHp() + "/" + player.getMaxHp());
            System.out.println("What will you do? ");
            printSeparator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Flee");
            int input = choices("->", 3);
            //react to player input
            if(input == 1){
                //FIGHT
                //calculate damage and taken damage
                int dmg = player.attack() - enemy.defend();
                int dmgTaken = enemy.attack() - player.defend();
                //check that dmg is not negative
                if(dmgTaken < 0){
                    //add damage if player defends well
                    dmg -= dmgTaken/2;
                    dmgTaken = 0;
                }
                if(dmg < 0)
                    dmg = 0;
                //deal damage to player and enemy
                player.damaged(dmgTaken);
                enemy.damaged(dmg);
                //print information of this battle turn
                clearConsole();
                printHeading("BATTLE");
                System.out.println("You dealt " + dmg + " damage to the " + enemy.getName() + ".");
                printSeparator(15);
                System.out.println("The " + enemy.getName() + " dealt " + dmgTaken + " damage to you.");
                pressAnything();
                //is the player alive?
                if(player.getHp() <= 0){
                    playerDied();
                    break;
                }else if(enemy.getHp() <= 0){
                    //tell the player they won
                    clearConsole();
                    printHeading("The " + enemy.getName() + " has been defeated!");
                    //increase player xp
                    player.xpGain(enemy.getXp());
                    System.out.println("You gained " + enemy.getXp() + "xp from the " + enemy.getName() + "!");
                    //random drops
                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                    int goldEarned = (int) (Math.random()*enemy.getXp());
                    if(addRest){
                        player.restsLeft++;
                        System.out.println("You have earned an additional rest!");
                    }
                    if(goldEarned > 0){
                        player.gold += goldEarned;
                        System.out.println("You collected " + goldEarned + " gold from the " + enemy.getName() + "!");
                    }
                    pressAnything();
                    break;
                }
            }else if(input == 2){
                //use potion
                if(player.potions > 0 && player.getHp() < player.getMaxHp()){
                    //conditions met to use a potion
                    //ask for confirmation to use potion
                    printHeading("Drink potion? You have " + player.potions + " left.");
                    System.out.println("(1) Yes\n(2) No, perhaps later");
                    input = choices("-> ", 2);
                    if(input == 1){
                        //player took potion
                        player.potionHealHp();
                        clearConsole();
                        printHeading("Potion taken! You feel much better now. HP is now back max.");
                        pressAnything();
                    }
                }else{
                    //cannot take potion
                    if (player.potions == 0)
                        printHeading("You have no potions");
                     else
                        printHeading("You are already at max HP");
                     pressAnything();
                }
            }else{
                //Flee
                clearConsole();
                //is this the final act slash boss battle?
                if(act != 4){
                    //chance to escape is 50%
                    if(Math.random()*10 + 1 <= 5){
                        printHeading("You ran away! The " + enemy.getName() + "is now just a memory.");
                        pressAnything();
                        break;
                    }else {
                        printHeading("You couldn't get away!");
                        //player is punished with damage
                        int dmgTaken = enemy.attack();
                        System.out.println("You took " + dmgTaken + "from the failed escape attempt!");
                        pressAnything();
                        //is player still alive?
                        if (player.getHp() <= 0)
                            playerDied();
                    }
                }else{
                    printHeading("No turning back now. Face your destiny!");
                    pressAnything();
                }
            }
        }
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

    //The final battle of the game
    public static void finalBattle(){
        //creating the final boss and attributes
        battle(new Enemy("The Horned Spired Demon", 500));
        //print proper ending
        Story.printEnding(player);
        isRunning = false;
    }

    //method that gets called when the player dies
    public static void playerDied(){
        clearConsole();
        printHeading("You are dead. The journey is over...");
        printHeading("Your total xp was " + player.getXp() + ".\nGood luck next time!");
        System.out.println("Game closing...");
        isRunning = false;
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
