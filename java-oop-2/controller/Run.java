package controller;

import model.Account;
import model.Transfer;
import view.PrintInfo;
import view.PrintMessage;

import java.util.Scanner;

// 실행 로직 담당 클래스
public class Run {
    Scanner sc = new Scanner(System.in);

    // 계좌 생성
    Account acc1 = new Account("1111-11-211", "유소영", 10000);

    // 입출금 로직 담당 객체 생성
    Transfer transfer = new Transfer();
    // 출력 객체 생성
    PrintInfo info = new PrintInfo();
    PrintMessage message = new PrintMessage();

    // 프로그램 실행 메서드
    public void run() {
        while (true) {
            System.out.println("===== 메뉴 선택 =====");
            System.out.println("1. 입금하기");
            System.out.println("2. 출금하기");
            System.out.println("3. 계좌 정보 조회하기");
            System.out.println("4. 시스템 종료");
            System.out.println("원하는 번호 입력 : ");

            int num = sc.nextInt();

            switch (num) {
                case 1:
                    System.out.println("입금할 금액을 입력하시오 : ");
                    int depositMoney = sc.nextInt();

                    boolean dResult = transfer.deposit(acc1, depositMoney);

                    if (dResult) {
                        message.printDeposit(depositMoney, acc1.getBalance());
                    } else {
                        message.printDepositFail();
                    }
                    break;

                case 2:
                    System.out.println("출금할 금액을 입력하시오 : ");
                    int withDrawMoney = sc.nextInt();

                    boolean wResult = transfer.withdraw(acc1, withDrawMoney);

                    if (wResult) {
                        message.printWithdraw(withDrawMoney, acc1.getBalance());
                    } else {
                        message.printWithdrawFail(acc1.getBalance());
                    }
                    break;

                case 3:
                    info.printAccountInfo(acc1);
                    break;

                case 4:
                    System.out.println("시스템을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("잘못된 번호를 입력했습니다. 1~4번만 입력해 주세요.");
            }

            System.out.println();
        }
    }
}