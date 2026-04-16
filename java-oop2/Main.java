import controller.AccountController;
import model.Account;
import view.UserMenu;


public class Main{
    public  static void main(String[] args){
        Account account = new Account(123,"LEE",0);
        UserMenu userMenu = new UserMenu();

        AccountController a = new AccountController(account,userMenu);

        a.run();






    }

}
