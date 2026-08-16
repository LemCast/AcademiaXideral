package characters;

public abstract class Character {

    //attributes every character has
   private String name;
   private final int maxHp;
   private int hp, xp;

   //constructor for character
    public Character(String name,int maxHp, int xp){
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void restHealHp(int hpCurrent) {
        int hpRestored = (int) (Math.random() * (xp / 4 + 1) + 10);
        this.hp = hpCurrent + hpRestored;
    }

    public void potionHealHp() {
        this.hp = maxHp;
    }

    public void damaged(int damage){
        this.hp -= damage;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getXp() {
        return xp;
    }

    public void xpGain(int enemyXp) {
        this.xp += enemyXp;
    }
}
