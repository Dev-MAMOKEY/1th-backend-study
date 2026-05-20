package model;

import view.ControlFail;
import view.Status;

public class AirConditioner implements RemoteControl{
    private boolean power;
    private int volume;
    private final int MAX_VOLUME = 32;

    private static final ControlFail controlFail = new ControlFail();
    private static final Status status = new Status();

    public AirConditioner(){
        this(false, 26);
    }

    public AirConditioner(int volume){
        this(false, volume);
    }

    public AirConditioner(boolean power, int volume){
        this.power = power;
        this.volume = volume;
    }

    @Override
    public String getDevice() {
        return "에어컨";
    }

    @Override
    public String getVolumeLabel() {
        return "온도";
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
            // 올리기 실패 코드
            controlFail.upFail(MAX_VOLUME);
        } else {
            // 전원 꺼짐
            controlFail.offFail(getDevice());
        }
    }

    @Override
    public void volumeDown(){
        if (power == true && volume > 0){
            volume--;
            status.volumeDown(getDevice(), getVolumeLabel(), volume);
        } else if (power == true && volume == 0){
            // 내리기 실패 코드
            controlFail.downFail(0);
        } else {
            controlFail.offFail(getDevice());
        }
    }
}
