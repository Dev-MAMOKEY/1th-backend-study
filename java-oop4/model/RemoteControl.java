package model;

public interface RemoteControl {
     void  turnOn();
     void turnOff();
     boolean volumeUp();
     boolean  volumeDown();
     String getName();
     boolean getPower();
     int getVolume();
     int getMaxVolume();
     int getMinVolume();

}
