package domain.account.view;

import domain.account.entity.Account;

public class AccountView {

    public void printMenu() {
        System.out.println("""
                ===== 메뉴 선택 =====
                1. 입금하기
                2. 출금하기
                3. 계좌 정보 조회하기
                4. 시스템 종료
                """);

        System.out.print("번호 입력 : ");
    }

    public void printDepositInput() {
        System.out.print("입금할 금액 입력 : ");
    }

    public void printWithdrawInput() {
        System.out.print("출금할 금액 입력 : ");
    }

    public void printDepositSuccess(int money, int balance) {
        System.out.println(money + "원 입금 완료 / 잔액 : " + balance);
    }

    public void printWithdrawSuccess(int money, int balance) {
        System.out.println(money + "원 출금 완료 / 잔액 : " + balance);
    }

    public void printInvalidDeposit() {
        System.out.println("잘못된 금액입니다.");
    }

    public void printInvalidWithdraw() {
        System.out.println("잔액 부족 또는 잘못된 금액입니다.");
    }

    public void printOnlyNumber() {
        System.out.println("숫자만 입력해 주세요.");
    }

    public void printWrongMenu() {
        System.out.println("잘못된 메뉴입니다.");
    }

    public void printExitMessage() {
        System.out.println("시스템 종료");
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printAccountInfo(Account account) {
        System.out.printf("""
                ===== 계좌 정보 =====
                은행 이름 : %s
                계좌 번호 : %s
                계좌 주인 : %s
                계좌 잔고 : %d
                ====================
                """,
                Account.BANK_NAME,
                account.getAccountNumber(),
                account.getOwner(),
                account.getBalance()
        );
    }
}