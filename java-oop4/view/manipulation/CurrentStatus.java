package view.manipulation;

import model.RemoteControl;

public class CurrentStatus {
    public void currentPower(RemoteControl remoteControl,String productName){
        if(remoteControl.getPower()){
            System.out.printf("*%s의 전원이 켜져있습니다.*\n",productName);
        }else{
            System.out.printf("*%s의 전원이 꺼져있습니다*\n",productName);
        }
    }
    public void currentVolum(RemoteControl remoteControl, String productName){
        System.out.printf("*현재 %s의 volum은 %d 입니다\n*",productName,remoteControl.getVolume());
    }

}
