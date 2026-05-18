package controller;

import model.charactor.Character;
import model.ChoiceUser;
import view.UserView;
import view.attackmessage.AttackMessage;

public class CharacterController {
    private final UserView userView;
    private final ChoiceUser choiceUser;
    private final AttackController attackController;

    private Character character;
    private AttackMessage attackMessage;

    public CharacterController(UserView userView, ChoiceUser choiceUser, AttackController attackController){
        this.userView = userView;
        this.choiceUser=choiceUser;
        this.attackController =attackController;

    }

    public Character run(){
        int choice = userView.userInput();
        this.character = choiceUser.create(choice);
        this.attackMessage = attackController.choiceAttack(choice);
        return character;
    }
    public  AttackMessage getAttackMessage(){
        return attackMessage;
    }
    }


