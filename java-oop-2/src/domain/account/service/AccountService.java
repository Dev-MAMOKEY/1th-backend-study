package domain.account.service;

import domain.account.entity.Account;

public class AccountService {

    public boolean deposit(Account account, int money) {
        if (money <= 0) {
            return false;
        }

        account.deposit(money);
        return true;
    }

    public boolean withdraw(Account account, int money) {
        if (money <= 0) {
            return false;
        }

        if (account.getBalance() - money < Account.MIN_BALANCE) {
            return false;
        }

        account.withdraw(money);
        return true;
    }
}