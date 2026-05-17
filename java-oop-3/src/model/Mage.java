package model;

public class Mage extends Character{
    public Mage(){
        super("Mage", 100, 30);
    }

    @Override
    public String attack(){
        return getName() + " casts fireball!";
    }
}
