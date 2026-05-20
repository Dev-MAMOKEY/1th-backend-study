package view;
import model.Account;

public class PrintAccountInfo {
    public void printAccountInfo(Account account) {
        System.out.printf("""
                =============================
                계좌 번호: %s
                계좌 명의자: %s
                계좌 금액: %d
                =============================
                """, account.getAccountNumber(), account.getOwner(), account.getBalance());
    }
}