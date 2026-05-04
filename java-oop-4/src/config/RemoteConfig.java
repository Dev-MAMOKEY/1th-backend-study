package config;

import controller.ControlController;
import controller.InputController;
import model.AirConditioner;
import model.RemoteControl;
import model.Television;
import view.RemoteView;

public class RemoteConfig {

    private RemoteControl[] devices;
    private RemoteView view;
    private ControlController controlController;
    private InputController inputController;

    public RemoteConfig() {
        devices = new RemoteControl[]{new Television(), new AirConditioner()}; // 만약에 기기를 추가하고 싶으면 모델 import후 여기에 new Speaker()만 추가
        view = new RemoteView();
        controlController = new ControlController();
        inputController = new InputController(view);
    }

    public RemoteControl[] getDevices() {
        return devices;
    }

    public RemoteView getView() {
        return view;
    }

    public ControlController getControlController() {
        return controlController;
    }

    public InputController getInputController() {
        return inputController;
    }
}