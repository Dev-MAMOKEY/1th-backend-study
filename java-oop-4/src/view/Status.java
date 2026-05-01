package view;

public class Status {
    public void turnOn(String device) {
        System.out.println(device + " 기기의 전원이 켜졌습니다.");
    }

    public void turnOff(String device) {
        System.out.println(device + " 기기의 전원이 꺼졌습니다.");
    }

    public void volumeUp(String device, String label, int volume) {
        System.out.println(device + " 기기의 " + label + "이(가) " + volume + "(으)로 올랐습니다.");
    }

    public void volumeDown(String device, String label, int volume) {
        System.out.println(device + " 기기의 " + label + "이(가) " + volume + "(으)로 내렸습니다.");
    }
}
