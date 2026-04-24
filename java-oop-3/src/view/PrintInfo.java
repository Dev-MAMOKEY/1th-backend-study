package view;

import model.Character;

public class PrintInfo {
    public void printInfo(Character character) {
        System.out.println();
        System.out.println("===== 캐릭터 정보 =====");
        System.out.println("이름: " + character.getName());
        System.out.println("체력: " + character.getHp());
        System.out.println("공격력: " + character.getAttackPower());
        System.out.println("공격 행동: " + character.attack());
    }

}
