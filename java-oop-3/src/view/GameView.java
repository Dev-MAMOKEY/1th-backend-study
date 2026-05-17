package view;

import model.Character;

public class GameView {

    public void printMenu() {
        System.out.println("캐릭터를 선택하세요.");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. 종료하기");
        System.out.print("선택: ");
    }

    public void printInfo(Character character) {
        System.out.println();
        System.out.println("===== 캐릭터 정보 =====");
        System.out.println("이름: " + character.getName());
        System.out.println("체력: " + character.getHp());
        System.out.println("공격력: " + character.getAttackPower());
        System.out.println("공격 행동: " + character.attack());
    }

    public void printErrorMessage() {
        System.out.println("없는 번호입니다.");
    }

    public void printExitMessage() {
        System.out.println("프로그램을 종료합니다.");
    }
}