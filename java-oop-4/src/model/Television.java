package model;

public class Television extends AbstractRemoteControl {

    private int volume = 10;
    private final int MIN_VOLUME = 0;
    private final int MAX_VOLUME = 100;

    @Override
    public void controlUp() {
        if (volume < MAX_VOLUME) {
            volume++;
        }
    }

    @Override
    public void controlDown() {
        if (volume > MIN_VOLUME) {
            volume--;
        }
    }

    @Override
    public String getName() {
        return "TV";
    }

    @Override
    public String getControlName() {
        return "음량";
    }

    @Override
    public int getValue() {
        return volume;
    }

    @Override
    public int getMinValue() {
        return MIN_VOLUME;
    }

    @Override
    public int getMaxValue() {
        return MAX_VOLUME;
    }
}