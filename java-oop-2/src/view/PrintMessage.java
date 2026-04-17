package view;

public class PrintMessage {

    public void printDeposit(int amount, int balance) {
        System.out.printf("""
                해당 계좌에 %d원을 입금하였습니다.
                현재 계좌 금액: %d원
                """, amount, balance);
    }

    public void printWithdraw(int amount, int balance) {
        System.out.printf("""
                해당 계좌에 %d원을 출금하였습니다.
                현재 계좌 금액: %d원
                """, amount, balance);
    }

    public void printDepositError(int balance) {
        System.out.printf("""
                금액을 잘못 입력하였습니다.
                현재 계좌 금액: %d원
                """, balance);
    }

    public void printWithdrawError(int balance) {
        System.out.printf("""
                해당 계좌에 금액이 부족하여 출금할 수 없습니다.
                현재 계좌 금액: %d원
                """, balance);
    }
}