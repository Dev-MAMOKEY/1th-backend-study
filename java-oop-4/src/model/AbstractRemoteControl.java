package model;

public abstract class AbstractRemoteControl implements RemoteControl {

    // 모든 전자기기가 공통으로 가지는 전원 상태입니다.
    protected boolean powerOn = false;

    // 전원을 켜면 상태를 true로 변경합니다.
    @Override
    public void turnOn() {
        powerOn = true;
    }

    // 전원을 끄면 상태를 false로 변경합니다.
    @Override
    public void turnOff() {
        powerOn = false;
    }

    // 현재 전원 상태를 반환합니다.
    @Override
    public boolean isPowerOn() {
        return powerOn;
    }
}