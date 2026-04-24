package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSelect {
    public int menuSelect() {
        Scanner scanner = new Scanner(System.in);
        int select;

        while(true) {
            System.out.println("플레이 할 캐릭터를 선택하십시오.");
            System.out.println("[1]: Warrior");
            System.out.println("[2]: Mage");
            System.out.println("[0]: 종료");
            System.out.print("번호 입력: ");

            try {
                select = scanner.nextInt();

                switch (select) {
                    case 0:
                    case 1:
                    case 2:
                        return select;
                    default:
                        System.out.println("위의 표시된 숫자 중 하나를 입력하여 주십시오.");
                        System.out.println();
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("위의 표시된 정수 숫자를 입력하여 주십시오.");
                System.out.println();
                scanner.nextLine();
            }
        }
    }
}