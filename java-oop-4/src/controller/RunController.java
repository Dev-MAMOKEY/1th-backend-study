package controller;

import model.AirConditioner;
import model.RemoteControl;
import model.Television;
import view.RemoteView;

public class RunController {

    private RemoteControl[] devices;
    private RemoteView view;
    private VolumeController volumeController;
    private InputController inputController;

    public RunController() {
        devices = new RemoteControl[]{ new Television(), new AirConditioner() };
        view = new RemoteView();
        volumeController = new VolumeController();
        inputController = new InputController(view);
    }

    public void run() {

        for (RemoteControl device : devices) {

            int answer = inputController.validTurnOn(device);

            if (answer == 1) {
                device.turnOn();

                int menu = inputController.validMenu();
                int amount = inputController.validAmount(device, menu);

                volumeController.controlVolume(device, menu, amount);

                view.printStatus(device);
                device.turnOff();
            }
        }

        System.out.println();
        System.out.println("프로그램을 종료합니다.");
    }
}