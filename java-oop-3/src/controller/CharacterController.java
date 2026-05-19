package controller;

import model.Character;
import model.Warrior;
import model.Mage;
import view.MenuSelect;
import view.CharacterInfo;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CharacterController {
    private final Scanner scanner = new Scanner(System.in);
    private final MenuSelect menuSelect = new MenuSelect();
    private final CharacterInfo characterInfo = new CharacterInfo();

    public void run() {
        while (true) {
            menuSelect.showMenu();

            int select;

            try {
                select = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해 주십시오.");
                scanner.nextLine();
                continue;
            }

            Character character;

            switch (select) {
                case 1:
                    character = new Warrior();
                    break;
                case 2:
                    character = new Mage();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 0, 1, 2 중에서 원하는 숫자를 선택하여 주십시오.");
                    continue;
            }

            characterInfo.characterInfo(character);
            character.action();
        }
    }
}