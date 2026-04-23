package view;
import java.util.InputMismatchException;
import java.util.Scanner;
public class UserView {

    public int userInput() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (true) {
            try {
                System.out.println("출력하고 싶은 캐릭터 번호를 입력하세요");
                System.out.println("1.전사");
                System.out.println("2.마녀");
                choice = sc.nextInt();
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("1번 2번만 입력가능합니다");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력가능합니다");
                sc.nextLine();
            }
        }
        return choice;
    }

}
