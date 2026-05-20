package view;

public class ControlFail {
    public void upFail(int volume) {
        System.out.printf("""
                더 이상 올릴 수 없습니다.
                현재 수치: %d
                """, volume);
    }
    public void downFail(int volume) {
        System.out.printf("""
                더 이상 내릴 수 없습니다.
                현재 수치: %d
                """, volume);
    }

    public void offFail(String device) {
        System.out.println(device + " 기기의 전원이 꺼져있어 조절할 수 없습니다.");
    }

    public void alreadyOnFail(String device) {
        System.out.println("이미 " + device + "(이)가 켜져 있습니다.");
    }

    public void alreadyOffFail(String device) {
        System.out.println("이미 " + device + "(이)가 꺼져 있습니다.");
    }
}
