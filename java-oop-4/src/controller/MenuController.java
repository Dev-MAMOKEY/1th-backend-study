package controller;

import model.RemoteControl;

public class MenuController {
    public void featureSelect(int secondSelect, RemoteControl device) {
        switch (secondSelect) {
            case 1:
                device.turnOn();
                break;
            case 2:
                device.turnOff();
                break;
            case 3:
                device.volumeUp();
                break;
            case 4:
                device.volumeDown();
                break;
            case 0:
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
}