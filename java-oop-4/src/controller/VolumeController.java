package controller;

import model.RemoteControl;

public class VolumeController {

    public void controlVolume(RemoteControl device, int menu, int amount) {

        switch (menu) {
            case 1:
                for (int i = 0; i < amount; i++) {
                    device.volumeUp();
                }
                break;

            case 2:
                for (int i = 0; i < amount; i++) {
                    device.volumeDown();
                }
                break;
        }
    }
}