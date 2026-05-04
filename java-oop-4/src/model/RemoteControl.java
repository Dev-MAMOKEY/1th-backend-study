package model;

public interface RemoteControl {

    void turnOn();

    void turnOff();

    void controlUp();

    void controlDown();

    String getName();

    String getControlName();

    int getValue();

    int getMinValue();

    int getMaxValue();

    boolean isPowerOn();
}