package model;

public class Withdraw {
    public boolean withdraw(Account account, int amount) {
        if (amount < 0) {
            return false;
        }

        if (account.getBalance() - amount < Account.MIN_BALANCE) {
            return false;
        } else {
            account.setBalance(account.getBalance() - amount);

            return true;
        }
    }
}