package characters;

import game.GameLogic;

public class Player extends Character{

    //Integers to count the upgrades the player has
    public int numAtkUpgrades, numDefUpgrades;

    //Character skill arrays
    public String[] atkUpgrades = {"Strong", "Fighter", "Swordfighter", "Gunner"};
    public String[] defUpgrades = {"Bulky", "Leather Armor", "Chain Armor", "Orichalcum Armor"};

    //Player specific constructor
    public Player(String name) {
        super(name, 50, 0);
        //Setting the number of initial upgrades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        //Let the player select a character trait on initial creation
        chooseTrait();
    }

    //Player specific methods overriding Character super class
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait: ");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        //Obtaining player's choice
        int input = GameLogic.choices("->", 2);
        GameLogic.clearConsole();
        //Dealing with options
        if(input == 1){
            GameLogic.printHeading("Alright, you chose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else{
            GameLogic.printHeading("Alright, you chose " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.pressAnything();

    }
}
