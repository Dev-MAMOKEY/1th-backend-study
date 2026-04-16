package view;
import model.Account;

// 계좌 정보 콘솔 출력 담당 클래스
public class PrintInfo {
    public void printAccountInfo(Account account){
        System.out.println("===== 계좌 정보 =====");
        System.out.println("은행 이름 : " + Account.bankName);
        System.out.println("계좌 번호 : " + account.getAccountNumber());
        System.out.println("계좌 주인 : " + account.getOwner());
        System.out.println("계좌 잔고 : " + account.getBalance());
        System.out.println("====================");

    }
}
