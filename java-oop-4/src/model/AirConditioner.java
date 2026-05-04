package model;

public class AirConditioner extends AbstractRemoteControl {

    private int temperature = 24;
    private final int MIN_TEMPERATURE = 18;
    private final int MAX_TEMPERATURE = 30;

    @Override
    public void controlUp() {
        if (temperature < MAX_TEMPERATURE) {
            temperature++;
        }
    }

    @Override
    public void controlDown() {
        if (temperature > MIN_TEMPERATURE) {
            temperature--;
        }
    }

    @Override
    public String getName() {
        return "에어컨";
    }

    @Override
    public String getControlName() {
        return "온도";
    }

    @Override
    public int getValue() {
        return temperature;
    }

    @Override
    public int getMinValue() {
        return MIN_TEMPERATURE;
    }

    @Override
    public int getMaxValue() {
        return MAX_TEMPERATURE;
    }
}