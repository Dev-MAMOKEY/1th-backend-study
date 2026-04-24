package model;

public class Warrior extends Character {
    public Warrior() {
        super("Warrior", 100, 10);
    }

    @Override
    public String attack() {
        return "Warrior attacks with sword!";
    }
}