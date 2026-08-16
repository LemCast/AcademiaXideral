package game;

import characters.Player;

import static game.GameLogic.player;

//Stores methods to print story sections of the game
public class Story {

    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("STORY");
        GameLogic.printSeparator(30);
        System.out.println("You wander into the woods, deciding to clear your mind and take fresh air.");
        System.out.println("However, your tranquil trip becomes interrupted by a dark wizard, and then everything cuts to black.");
        System.out.println("When you come to be again, your body feels heavy and desolate.");
        System.out.println("You are cursed. Your goal is to find the wizard and put an end to the nightmare");
        GameLogic.pressAnything();
    }

    public static void printFirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT I - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("Your instincts bring you towards the right path, moving along a calm path in the woods");
        System.out.println("You are equipped with your wits and determination. Without further ado, you proceed.");
        GameLogic.pressAnything();
    }

    public static void printFirstActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT I - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("You finally escape the woods, reaching a giant fortress.");
        System.out.println("It appears to be an abandoned castle, the high towers disappearing into the night sky as you look up.");
        System.out.println("A sense of dread begins to wash over you.");
        GameLogic.pressAnything();
    }

    public static void printSecondActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT II - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("Against all instincts, you head into the castle, determined to rid yourself of the unholy curse.");
        System.out.println("May luck be with you from this point on.");
        GameLogic.pressAnything();
    }

    public static void printSecondActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT II - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("You manage to make it to the top of the castle.");
        System.out.println("A pitch dark portal sits on what appears to be the throne room");
        System.out.println("Will you be brave enough to reach to the other side?");
        GameLogic.pressAnything();
    }

    public static void printThirdActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT III - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("The world on the other side of the portal reveals a desolate wasteland.");
        System.out.println("The heat becomes insurmountable, but your determination burns hotter.");
        System.out.println("This is the last straw. Keep moving forth.");
        GameLogic.pressAnything();
    }

    public static void printThirdActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT III - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("Against all odds, you arrive to the end of the wasteland.");
        System.out.println("A magnanimous mansion is here. A shiver runs through your body.");
        System.out.println("He is here, the dreaded dark mage.");
        GameLogic.pressAnything();
    }

    public static void printFourthActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT IV - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("You come face to face with the dark mage. His laughter echoes through the hall as he sees you arrive.");
        System.out.println("In a blink, the mage transforms into a grotesque monster, his eerie smile shining in his dark silhouette, taunting, menacing.");
        System.out.println("The Horned Spired Demon is here. This is the final battle.");
        GameLogic.pressAnything();
    }

    public static void printEnding(Player player){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("After a long and hard journey, you finally reach the end, " + player.getName() + ".");
        System.out.println("You break the curse, and finally manage to return home. Thank you for playing.");
        GameLogic.printSeparator(30);
        System.out.println("Spire Tip");
        System.out.println("By Aaron Garza");
    }
}
