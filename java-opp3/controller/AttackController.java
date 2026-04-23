package controller;

import view.attackmessage.AttackMessage;
import view.attackmessage.MageMessage;
import view.attackmessage.WarrioMessage;

public class AttackController {
    private AttackMessage attackMessage;

    public void choiceAttack(int choice){
        if(choice ==1){
            attackMessage = new MageMessage();
        }else if (choice == 2){
            attackMessage = new WarrioMessage();
        }else{
            attackMessage  = new AttackMessage();
        }
        attackMessage.attackMessage();
    }
}
