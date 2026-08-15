package game;

import static game.GameLogic.player;

//Stores methods to print story sections of the game
public class Story {

    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("STORY");
        GameLogic.printSeparator(30);
        System.out.println("Narrative 1");
        System.out.println("Narrative 2");
        System.out.println("Narrative 3");
        GameLogic.pressAnything();
    }

    public static void printFirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT I - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("Narrative 1");
        System.out.println("Narrative 2");
        System.out.println("Narrative 3");
        GameLogic.pressAnything();
    }

    public static void printFirstActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT I - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("Narrative 1");
        System.out.println("Narrative 2");
        System.out.println("Narrative 3");
        GameLogic.pressAnything();
    }

    public static void printSecondActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT II - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("Narrative 1");
        System.out.println("Narrative 2");
        System.out.println("Narrative 3");
        GameLogic.pressAnything();
    }

    public static void printSecondActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT II - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("Narrative 1");
        System.out.println("Narrative 2");
        System.out.println("Narrative 3");
        GameLogic.pressAnything();
    }

    public static void printThirdActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT III - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("Narrative 1");
        System.out.println("Narrative 2");
        System.out.println("Narrative 3");
        GameLogic.pressAnything();
    }

    public static void printThirdActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT III - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("Narrative 1");
        System.out.println("Narrative 2");
        System.out.println("Narrative 3");
        GameLogic.pressAnything();
    }

    public static void printFourthActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT II - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("Narrative 1");
        System.out.println("Narrative 2");
        System.out.println("Narrative 3");
        GameLogic.pressAnything();
    }

    public static void printEnding(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("After a long and hard journey, you finally reach the end, " + player.name + ".");
        System.out.println("The world is now saved. Thank you for playing.");
        GameLogic.printSeparator(30);
        System.out.println("Spire Tip");
        System.out.println("By Aaron Garza");
    }
}
