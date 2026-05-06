package view;
import java.util.Scanner;
public class UserMenu {
    Scanner sc = new Scanner(System.in);

    public int showMenu(){
        System.out.println("메뉴를 선택하세요");
        System.out.println("1.입금");
        System.out.println("2.출금");
        System.out.println("3.계좌 정보");
        System.out.println("4.현재 잔고");
        System.out.println("5.종료");
        return sc.nextInt();

    }
}
