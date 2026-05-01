package model;

public class AirConditioner implements RemoteControl {

    private int volume = 10;

    @Override
    public void turnOn() {
        System.out.println("에어컨 전원 ON");
    }

    @Override
    public void turnOff() {
        System.out.println("에어컨 전원 OFF");
    }

    @Override
    public void volumeUp() {
        volume++;
    }

    @Override
    public void volumeDown() {
        if (volume > 0) {
            volume--;
        }
    }

    @Override
    public String getName() {
        return "에어컨";
    }

    @Override
    public int getVolume() {
        return volume;
    }
}