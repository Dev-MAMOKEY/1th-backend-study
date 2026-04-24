package model;

public class Character {
    private String name;
    private int hp;
    private int attackPower;

    public Character(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public String attack() {
        return "attacks";
    }

    public void action() {
        System.out.println(attack());
    }


    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackPower() {
        return attackPower;
    }
}