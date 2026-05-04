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
    @Override
    public void turnOff() {
        this.power = false;
    }
    @Override
    public boolean volumeUp() {
        if (this.power && this.volume < MAXVOLUME) {
            this.volume += 1;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean volumeDown() {
        if (this.power && this.volume > MINVOLUME) {
            this.volume -= 1;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String getName() {
        return NAME;
    }
    @Override
    public boolean getPower() {
        return this.power;
    }
    @Override
    public int getVolume(){
        return this.volume;
    }
    @Override
    public int getMaxVolume(){
        return this.MAXVOLUME;
    }
    @Override
    public int getMinVolume(){
        return this.MINVOLUME;
    }
}
