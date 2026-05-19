package view;

public class MenuSelect {
    public void showMenu() {
        System.out.printf("""
                \n플레이 할 캐릭터를 선택하십시오.
                [1]: Warrior
                [2]: Mage
                [0]: 종료
                번호 입력: 
                """);
    }
}