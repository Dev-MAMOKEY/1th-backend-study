package model;

public class Account {
    private String accountNumber;
    private String owner;
    private int balance;

    public Account(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    private static String bankName = "Mamoki Bank";
    private static final int MIN_BALANCE = 0;

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setBalance() {
        setBalance(0);
    }

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

    public boolean deposit(Account account, int amount) {
        if (amount < 0) {
            return false;
        }

        account.setBalance(account.getBalance() + amount);

        return true;
    }
}