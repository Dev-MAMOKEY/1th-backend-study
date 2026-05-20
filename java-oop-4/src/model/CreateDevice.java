package model;

public class CreateDevice {
    public RemoteControl[] createDevices() {
        return new RemoteControl[]{
                new Television(), new AirConditioner()
        };
    }
}
