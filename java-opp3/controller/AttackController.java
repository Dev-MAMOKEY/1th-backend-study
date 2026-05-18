package controller;

import view.attackmessage.AttackMessage;
import view.attackmessage.MageMessage;
import view.attackmessage.WarriorMessage;

public class AttackController {


    public AttackMessage choiceAttack(int choice) {
        if (choice == 1) {
            return new WarriorMessage();
        } else if (choice == 2) {
            return new MageMessage();
        } else {
            return new AttackMessage();
        }
    }
}
