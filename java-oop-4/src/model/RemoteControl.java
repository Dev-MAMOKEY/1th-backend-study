package model;

public interface RemoteControl {
    void turnOn();
    void turnOff();
    void volumeUp();
    void volumeDown();

    String getName();
    int getVolume();
}