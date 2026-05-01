package model;

public class Television implements RemoteControl {

    private int volume = 10;

    @Override
    public void turnOn() {
        System.out.println("TV 전원 ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV 전원 OFF");
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
        return "TV";
    }

    @Override
    public int getVolume() {
        return volume;
    }
}