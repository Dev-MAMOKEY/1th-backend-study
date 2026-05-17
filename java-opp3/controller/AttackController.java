package controller;

import view.attackmessage.AttackMessage;
import view.attackmessage.MageMessage;
import view.attackmessage.WarrioMessage;

public class AttackController {


    public AttackMessage choiceAttack(int choice) {
        if (choice == 1) {
            return new MageMessage();
        } else if (choice == 2) {
            return new WarrioMessage();
        } else {
            return new AttackMessage();
        }
    }
}
