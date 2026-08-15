package game;

public class Main {
    public static void main(String[] args){
        GameLogic.printHeading("Let's see if this works!");
        GameLogic.pressAnything();
        GameLogic.clearConsole();
        int input = GameLogic.choices("Enter 1, 2 or 3", 3);
        System.out.println("You chose number " + input);

    }
}
