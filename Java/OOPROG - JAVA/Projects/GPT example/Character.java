// Character.java
import java.util.Random;

abstract class Character {
    protected String name;
    protected int health;
    protected int strength;
    protected int defense;

    public Character(String name, int health, int strength, int defense) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.defense = defense;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public int attack() {
        Random rand = new Random();
        boolean critical = rand.nextBoolean(); // Random chance for a critical hit
        return critical ? (int) (strength * 1.5) : strength;
    }
}



