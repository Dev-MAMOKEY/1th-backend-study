import controller.AttackController;
import model.ChoiceUser;
import view.UserView;
import controller.CharactorController;

public class Runner {
    public static void run() {

        UserView userView = new UserView();
        ChoiceUser choiceUser = new ChoiceUser();
        AttackController attackController = new AttackController();

        CharactorController characterController = new CharactorController(userView, choiceUser, attackController);

        characterController.run();
    }
}