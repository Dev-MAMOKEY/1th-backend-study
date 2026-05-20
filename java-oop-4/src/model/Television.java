package model;

import view.ControlFail;
import view.Status;

public class Television implements RemoteControl{
    private boolean power;
    private int volume;
    private final int MAX_VOLUME = 100;

    private static final ControlFail controlFail = new ControlFail();
    private static final Status status = new Status();

    public Television(){
        this(false, 50);
    }

    public Television(int volume){
        this(false, volume);
    }

    public Television(boolean power, int volume){
        this.power = power;
        this.volume = volume;
    }

    @Override
    public String getDevice(){
        return "TV";
    }

    @Override
    public String getVolumeLabel() {
        return "볼륨";
    }

    @Override
    public void turnOn(){
        if (power == false) {
            power = true;
            status.turnOn(getDevice());
        } else {
            controlFail.alreadyOnFail(getDevice());
        }
    }

    @Override
    public void turnOff(){
        if (power == true) {
            power = false;
            status.turnOff(getDevice());
        } else {
            controlFail.alreadyOffFail(getDevice());
        }
    }

    @Override
    public void volumeUp(){
        if (power == true && volume < MAX_VOLUME){
            volume++;
            status.volumeUp(getDevice(), getVolumeLabel(), volume);
        } else if (power == true && volume == MAX_VOLUME){
            // 올리기 실패
            controlFail.upFail(MAX_VOLUME);
        } else {
            controlFail.offFail(getDevice());
        }
    }

    @Override
    public void volumeDown(){
        if (power == true && volume > 0){
            volume--;
            status.volumeDown(getDevice(), getVolumeLabel(), volume);
        } else if (power == true && volume == 0){
            // 내리기 실패
            controlFail.downFail(0);
        } else {
            controlFail.offFail(getDevice());
        }
    }
}