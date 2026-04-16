package model;
// 계좌
public class Account {
    static String backName = "Mamoki Bank";
    public final int MIN_BALABCE =0;

    private int accountNumber;
    private String owner;
    private int balance;

    public Account(int accountNumber, String owner, int balance){
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;

    }

    public int getBalance(){
        return this.balance;
    }
    public void setBalance(int money){
        this.balance = money;
    }
    public int getAccountNumber(){return this.accountNumber;}
    public String getOwner(){return owner;}
}
