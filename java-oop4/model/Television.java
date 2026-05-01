package model;

public class Television implements RemoteControl{
    private final int MAXVOLUME = 100;
    private final int MINVOLUME = 0;
    private final String NAME ="TV";
    private boolean power;
    private int volume;

    public Television(){
        this.power = false;
        this.volume = 10;
    }

    @Override
    public void turnOn(){
        this.power = true;
    }
    public void turnOff(){
        this.power = false;
    }
    public boolean volumeUp(){
        if(this.power && this.volume<MAXVOLUME){
            this.volume +=1;
            return true;
        }else{
            return false;
        }
    }
    public boolean volumeDown() {
        if (this.power && this.volume > MINVOLUME) {
            this.volume -= 1;
            return true;
        } else {
            return false;
        }
    }
    public String getName(){
        return this.NAME;
    }
    public boolean getPower() {
        return this.power;
    }
    public int getVolume(){return this.volume;}
}
