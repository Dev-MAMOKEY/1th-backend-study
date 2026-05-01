package model;

public class AirConditioner implements RemoteControl {
    private final int MAXVOLUME = 30;
    private final int MINVOLUME = 18;
    private final String NAME = "에어컨";
    private boolean power;
    private int volume;

    public AirConditioner() {
        this.power = false;
        this.volume = 20;
    }

    @Override
    public void turnOn() {
        this.power = true;
    }

    public void turnOff() {
        this.power = false;
    }

    public boolean volumeUp() {
        if (this.power && this.volume < MAXVOLUME) {
            this.volume += 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean volumeDown() {
        if (this.power && this.volume > MINVOLUME) {
            this.volume -= 1;
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return NAME;
    }

    public boolean getPower() {
        return this.power;
    }
    public int getVolume(){
        return this.volume;
    }
}
