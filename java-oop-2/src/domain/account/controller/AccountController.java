package domain.account.controller;

import domain.account.entity.Account;
import domain.account.service.AccountService;
import domain.account.view.AccountView;

import java.util.Scanner;

public class AccountController {

    private Scanner scanner = new Scanner(System.in);
    private Account account = new Account("111-11-211", "유소영", 10000);
    private AccountService accountService = new AccountService();
    private AccountView accountView = new AccountView();

    public void start() {
        while (true) {
            accountView.printMenu();

            int menu = inputNumber();

            switch (menu) {
                case 1:
                    deposit();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    accountView.printAccountInfo(account);
                    break;

                case 4:
                    accountView.printExitMessage();
                    scanner.close();
                    return;

                default:
                    accountView.printWrongMenu();
            }

            accountView.printBlankLine();
        }
    }

    private void deposit() {
        accountView.printDepositInput();

        int money = inputNumber();

        boolean result = accountService.deposit(account, money);

        if (result) {
            accountView.printDepositSuccess(money, account.getBalance());
            return;
        }

        accountView.printInvalidDeposit();
    }

    private void withdraw() {
        accountView.printWithdrawInput();

        int money = inputNumber();

        boolean result = accountService.withdraw(account, money);

        if (result) {
            accountView.printWithdrawSuccess(money, account.getBalance());
            return;
        }

        accountView.printInvalidWithdraw();
    }

    private int inputNumber() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            accountView.printOnlyNumber();
            return 0;
        }
    }
}