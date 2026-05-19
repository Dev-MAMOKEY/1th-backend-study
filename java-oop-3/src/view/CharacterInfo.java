package view;

import model.Character;

public class CharacterInfo {
    public void characterInfo(Character character) {
        System.out.printf("""
                \n캐릭터: %s
                체력: %d
                공격력: %d
                """, character.getName(), character.getHp(), character.getAttackPower());
    }
}