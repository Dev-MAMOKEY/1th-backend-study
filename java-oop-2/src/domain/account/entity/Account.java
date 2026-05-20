package domain.account.entity;

public class Account {

    public static final String BANK_NAME = "Mamokey Bank";
    public static final int MIN_BALANCE = 0;

    private final String accountNumber;
    private final String owner;
    private int balance;

    public Account(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int money) {
        balance += money;
    }

    public void withdraw(int money) {
        balance -= money;
    }
}