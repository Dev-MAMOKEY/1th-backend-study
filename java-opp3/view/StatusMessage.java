package view;
import model.charactor.Character;
public class StatusMessage {
    public static void statusMessage(Character character){
        System.out.printf("이름: %s  체력: %d  공격력: %d\n",character.getName(),character.getHp(),character.getAttackPower());
    }
}
