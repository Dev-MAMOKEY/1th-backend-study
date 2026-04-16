package model;

// 계좌 데이터 저장하는 클래스
public class Account {
    public static String bankName = "Mamokey Bank";
    public static final int MIN_BALANCE = 0;

    private String accountNumber;
    private String owner;
    private int balance;

    public Account(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    // getter, setter
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
