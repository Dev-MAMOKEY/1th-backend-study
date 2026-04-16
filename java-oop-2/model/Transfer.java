package model;

// 계좌 거래(입금/출금) 처리 클래스
public class Transfer {

    // 입금
    public boolean deposit(Account account, int money) {
        if (money <= 0) {
            return false;
        }

        int balance = account.getBalance();
        balance = balance + money;
        account.setBalance(balance);

        return true;
    }

    // 출금
    public boolean withdraw(Account account, int money) {
        if (money <= 0) {
            return false;
        }

        int balance = account.getBalance();

        if (balance - money < Account.MIN_BALANCE) {
            return false;
        } else {
            balance = balance - money;
            account.setBalance(balance);

            return true;
        }
    }
}