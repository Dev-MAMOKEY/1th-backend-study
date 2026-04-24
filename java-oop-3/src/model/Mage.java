package model;

public class Mage extends Character{
    public Mage() {
        super("Mage", 70, 20);
    }

    @Override
    public String attack() {
        return "Mage cats fireball!";
    }
}