import controller.AttackController;
import model.ChoiceUser;
import model.charactor.Character;
import view.StatusMessage;
import view.UserView;
import controller.CharacterController;
import view.attackmessage.AttackMessage;

public class Runner {
    public static void run() {

        UserView userView = new UserView();
        ChoiceUser choiceUser = new ChoiceUser();
        AttackController attackController = new AttackController();

        CharacterController characterController = new CharacterController(userView, choiceUser, attackController);
        Character a = characterController.run();
        StatusMessage.statusMessage(a);
        characterController.getAttackMessage().attackMessage();

    }
}