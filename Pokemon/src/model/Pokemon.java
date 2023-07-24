package model;

public class Pokemon {
    private String name;
    private int health;
    private int damage;
    private TypeEnum type;
    private SpecialPower specialPower;

    public Pokemon(String name, int health, int damage, TypeEnum type, SpecialPower specialPower) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.type = type;
        this.specialPower = specialPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public void specialAttac(){

    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", type=" + type +
                '}';
    }
}
