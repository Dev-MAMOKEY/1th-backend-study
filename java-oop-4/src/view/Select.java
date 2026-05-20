package view;

public class Select {
    public void firstSelect() {
        System.out.printf("""
                \n===== 기기 선택 =====
                [1] TV
                [2] 에어컨
                [0] 종료
                번호 입력: 
                """);
    }

    public void secondSelect(String label) {
        System.out.printf("""
                \n===== 기능 선택 =====
                [1] 전원 켜기
                [2] 전원 끄기
                [3] %s 올리기
                [4] %s 내리기
                [0] 뒤로가기
                번호 입력: 
                """, label, label);
    }
}
