package model.charactor;

public class Character {
    private String name;
    private int hp;
    private int attackPower;

    public Character(String name, int hp, int attackPower){
        this.name =name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public  String getName(){
        return name;
    }
    public int getHp(){
        return hp;
    }
    public int getAttackPower(){
        return attackPower;
    }


}
// 요번 과제가 클래스 상속을 이용하는 것이기때문에 인터페이스는 활용하지 않았습니다.