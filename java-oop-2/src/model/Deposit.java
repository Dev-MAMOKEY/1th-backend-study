package model;

public class Deposit {
    public boolean deposit(Account account, int amount) {
        if (amount < 0) {
            return false;
        }

        account.setBalance(account.getBalance() + amount);

        return true;
    }
}