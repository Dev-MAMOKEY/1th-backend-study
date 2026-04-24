package controller;

import model.Character;
import model.Warrior;
import model.Mage;
import view.MenuSelect;
import view.CharacterInfo;

public class Controller {
    public void run() {
        MenuSelect menuSelect = new MenuSelect();
        int select = menuSelect.menuSelect();

        Character character = null;
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
        }

        CharacterInfo characterInfo = new CharacterInfo();
        characterInfo.characterInfo(character);

        character.action();
    }
}