package view;

import model.Character;

public class CharacterInfo {
    public void characterInfo(Character character) {
        System.out.println();
        System.out.println("캐릭터: " + character.getName());
        System.out.println("체력: " + character.getHp());
        System.out.println("공격력: " + character.getAttackPower());
    }
}