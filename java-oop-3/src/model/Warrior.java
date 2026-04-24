package model;

public class Warrior extends Character {
    public Warrior(){
        super("Warrior", 150, 20);
    }

    @Override
    public String attack(){
        return getName()+ " attacks with sword!";
    }

}
