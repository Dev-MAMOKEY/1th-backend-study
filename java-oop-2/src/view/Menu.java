package view;

public class Menu {
    public void printMenu() {
        System.out.printf("""
                \n======== Mamoki Bank ========
                원하시는 서비스의 번호를 선택하십시오.
                1. 계좌 정보 확인
                2. 입금
                3. 출금
                0. 종료
                =============================
                번호 입력:
                """);
    }
}
