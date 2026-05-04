package controller;

import model.RemoteControl;
import view.ErrorMessage;
import view.ProductSelect;
import view.manipulation.CurrentStatus;
import view.manipulation.ManipulationMessage;

public class RemoteController {
    private final ProductSelect productSelect;
    private final RemoteControl[] remoteControl;
    private final CurrentStatus currentStatus;

    public  RemoteController(ProductSelect productSelect, RemoteControl[] remoteControl,CurrentStatus currentStatus){
        this.productSelect = productSelect;
        this.remoteControl =remoteControl;
        this.currentStatus =currentStatus;
    }


    public void  run(){
        int choice = productSelect.productSelect();
        if(choice==1){
            singleOperation(remoteControl[0]);

        }else if(choice ==2){
            singleOperation(remoteControl[1]);
        }else if(choice ==3){
            simulOperation(remoteControl);
        }else{
            ErrorMessage.errorInput();
        }
    }



    public void singleOperation(RemoteControl remoteControl){
        boolean loop = true;

        while(loop){
            int choice  = productSelect.stateSelect();
            switch (choice){
                case 1-> {
                    remoteControl.turnOn();
                    ManipulationMessage.turnonMessage(remoteControl.getName());
                }
                case 2 -> {
                    remoteControl.turnOff();
                    ManipulationMessage.turnoffMessage(remoteControl.getName());
                }
                case 3-> {
                    if(!remoteControl.getPower()){
                        ErrorMessage.powerCondition();
                        break;
                    }
                    if(remoteControl.volumeUp()){
                        ManipulationMessage.volumupMessage(remoteControl.getName());
                    }else{
                        ErrorMessage.volumeupError(remoteControl.getName(),remoteControl.getMaxVolume());
                    }

                }
                case 4 -> {
                    if(!remoteControl.getPower()){
                        ErrorMessage.powerCondition();
                        break;
                    }
                    if(remoteControl.volumeDown()){
                        ManipulationMessage.volumdownMessage(remoteControl.getName());
                    }else{
                        ErrorMessage.volumedownError(remoteControl.getName(),remoteControl.getMinVolume());
                    }
                }
                case 5 -> currentStatus.currentPower(remoteControl, remoteControl.getName());
                case 6 -> currentStatus.currentVolum(remoteControl,remoteControl.getName());
                case 7 -> loop = false;
                default -> ErrorMessage.errorInput();
            }

        }
    }
    public void simulOperation(RemoteControl[] remoteControl) {
        boolean loop = true;
        while (loop) {
            int choice = productSelect.stateSelect();
            switch (choice) {
                case 1 -> {
                    for (RemoteControl remote : remoteControl) {
                        remote.turnOn();
                        ManipulationMessage.turnonMessage(remote.getName());
                    }
                }
                case 2 -> {
                    for (RemoteControl remote : remoteControl) {
                        remote.turnOff();
                        ManipulationMessage.turnoffMessage(remote.getName());
                    }
                }
                case 3 -> {
                    for (RemoteControl remote : remoteControl) {
                        if (!remote.getPower()) {
                            ErrorMessage.powerCondition();
                            continue;
                        }
                        if (remote.volumeUp()) {
                            ManipulationMessage.volumupMessage(remote.getName());
                        } else {
                            ErrorMessage.volumeupError(remote.getName(),remote.getMaxVolume());
                        }
                    }
                }
                    case 4 -> {
                        for (RemoteControl remote : remoteControl) {
                            if(!remote.getPower()){
                                ErrorMessage.powerCondition();
                                continue;
                            }
                            if(remote.volumeDown()){
                                ManipulationMessage.volumdownMessage(remote.getName());
                            }else{
                                ErrorMessage.volumedownError(remote.getName(),remote.getMinVolume());
                            }

                        }
                    }
                    case 5 -> {
                        for (RemoteControl remote : remoteControl) {
                            currentStatus.currentPower(remote, remote.getName());
                        }
                    }
                    case 6 -> {
                        for (RemoteControl remote : remoteControl) {
                            currentStatus.currentVolum(remote, remote.getName());
                        }
                    }
                    case 7 -> loop = false;
                    default -> ErrorMessage.errorInput();
                }

            }
        }


    }


