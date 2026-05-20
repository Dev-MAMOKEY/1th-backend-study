package controller;

import java.util.Scanner;

import model.Account;
import view.PrintAccountInfo;
import view.PrintMessage;
import view.Menu;

public class Run {
    Scanner scanner = new Scanner(System.in);

    Account account1 = new Account("001", "최정훈", 100000);

    PrintAccountInfo printAccountInfo = new PrintAccountInfo();
    PrintMessage printMessage = new PrintMessage();
    Menu menu = new Menu();

    public void run() {
        boolean run = true;
        while (run) {
            menu.printMenu();
            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    printAccountInfo.printAccountInfo(account1);
                    break;

                case 2:
                    System.out.print("입금할 금액의 양을 입력하십시오: ");
                    int depositAmount = scanner.nextInt();

                    if (account1.deposit(account1, depositAmount)) {
                        printMessage.printDeposit(depositAmount, account1.getBalance());
                    } else {
                        printMessage.printDepositError(account1.getBalance());
                    }
                    break;

                case 3:
                    System.out.print("출금할 금액의 양을 입력하십시오: ");
                    int withdrawAmount = scanner.nextInt();

                    if (account1.withdraw(account1, withdrawAmount)) {
                        printMessage.printWithdraw(withdrawAmount, account1.getBalance());
                    } else {
                        printMessage.printWithdrawError(account1.getBalance());
                    }
                    break;

                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }

        scanner.close();
    }
}