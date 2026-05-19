package model;

public interface RemoteControl {
    public void turnOn();
    public void turnOff();
    public void volumeUp();
    public void volumeDown();
    public String getDevice();
    public String getVolumeLabel();
}