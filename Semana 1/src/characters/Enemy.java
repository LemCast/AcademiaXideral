package characters;

public class Enemy extends Character implements CanAttack, CanDefend{
    //Enemy IS-A Character
    //variable to store the player's current xp
    int playerXp;

    //enemy specific constructor
    public Enemy(String name, int playerXp) {
        super(name, (int) (Math.random()*playerXp + playerXp/3 +5), (int) (Math.random()*(playerXp/4 + 2) + 1));
        //assigning variable
        this.playerXp = playerXp;

    }
    //Enemy specific attack and defense calculations
    @Override
    public int attack() {
        return (int) (Math.random()*(playerXp/4 + 1) + getXp()/4 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(playerXp/4 + 1) + getXp()/4 + 3);
    }

    @Override //Quick comparable addition. This program does not have a big window to exemplify this since comparisons are scarce, but adding a collections sort would now be possible if needed based on XP.
    public int compareTo(Character o) {
        return Integer.compare(this.getXp(), o.getXp());
    }
}
