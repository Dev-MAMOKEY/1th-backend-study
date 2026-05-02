package controller;

import java.util.Scanner;

import model.Character;
import model.Mage;
import model.Warrior;

import view.*;

public class Run {

    public void run(){
        Scanner scanner = new Scanner(System.in);

        GameView gameView = new GameView();

        while (true) {

            gameView.printMenu();

            int choice = scanner.nextInt();

            // Warrior나 Mage객체를 저장할 부모 타입(Character) 변수 선언
            Character character;

            switch (choice){
                case 1:
                    character = new Warrior();
                    break;
                case 2:
                    character = new Mage();
                    break;
                case 3:
                    gameView.printExitMessage();
                    return;
                default:
                    gameView.printErrorMessage();
                    continue;
            }

            // 실제 객체가 Warrior인지 Mage인지에 따라, 각 클래스에서 오버라이딩된 attack()이 실행됨
            gameView.printInfo(character);

            System.out.println();
        }
    }
}