package view;

// 입출금 콘솔 출력 담당 클래스
public class PrintMessage {

    public void printDeposit(int money, int balance) {
        System.out.println(money + "원 입금 완료 / 잔액 : " + balance);
    }

    public void printWithdraw(int money, int balance) {
        System.out.println(money + "원 출금 완료 / 잔액 : " + balance);
    }

    public void printWithdrawFail(int balance) {
        System.out.println("잔액 부족 또는 잘못된 금액입니다. / 잔액 : " + balance);
    }

    public void printDepositFail() {
        System.out.println("잘못된 금액입니다.");
    }
}