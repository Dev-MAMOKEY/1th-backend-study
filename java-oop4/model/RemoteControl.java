package model;

public interface RemoteControl {
    public void  turnOn();
    public void turnOff();
    public boolean volumeUp();
    public boolean  volumeDown();
    public String getName();
    public boolean getPower();
    public int getVolume();
}
