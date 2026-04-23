package controller;

import model.charactor.Character;
import model.ChoiceUser;
import view.StatusMessage;
import view.UserView;

public class CharactorController {
    private UserView userView;
    private Character character;
    private ChoiceUser choiceUser;
    private AttackController attackmessage;

    public CharactorController(UserView userView, ChoiceUser choiceUser,AttackController attackmessage){
        this.userView = userView;
        this.choiceUser=choiceUser;
        this.attackmessage =attackmessage;

    }

    public void  run(){
        int choice = userView.userInput();
        this.character = choiceUser.create(choice); // 여기서 다형성 사용하였습니다.
        StatusMessage.statusMessage(this.character);
        attackmessage.choiceAttack(choice);


        }
    }


