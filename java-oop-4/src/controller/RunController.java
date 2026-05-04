package controller;

import config.RemoteConfig;
import model.RemoteControl;
import view.RemoteView;

public class RunController {

    private RemoteControl[] devices;
    private RemoteView view;
    private ControlController controlController;
    private InputController inputController;

    public RunController() {
        RemoteConfig config = new RemoteConfig();

        devices = config.getDevices();
        view = config.getView();
        controlController = config.getControlController();
        inputController = config.getInputController();
    }

    public void run() {
        for (RemoteControl device : devices) {
            int answer = inputController.validTurnOn(device);

            if (answer == 1) {
                device.turnOn();
                view.printPowerOn(device);

                int menu = inputController.validMenu(device);
                int amount = inputController.validAmount(device, menu);

                controlController.control(device, menu, amount);

                view.printStatus(device);

                device.turnOff();
                view.printPowerOff(device);
            }
        }

        view.printEnd();
    }
}