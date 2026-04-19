package controller;
import model.Account;
import model.bankservice.Deposit;
import model.bankservice.Transactions;
import model.bankservice.Withdrawal;
import view.message.accountinformation.UserInformation;
import view.message.errormessage.*;
import view.UserMenu;
import view.userinput.DepositInput;
import view.userinput.UserInput;
import view.userinput.WithdrawalInput;
public class AccountController {
    private  Account account;
    private  UserMenu userMenu;



    public AccountController(Account account, UserMenu userMenu){
        this.account =account;
        this.userMenu = userMenu;

    }

    public void run(){
        boolean loop = true;
        while(loop) {
            int selectMenu = userMenu.showMenu();
            switch (selectMenu) {
                case 1 -> startTransaction(new DepositInput(), ErrorMessage.DEPOSIT, new Deposit());
                case 2 -> startTransaction(new WithdrawalInput(), ErrorMessage.WITHDRAWAL, new Withdrawal());
                case 3-> UserInformation.userinformation(account);
                case 4 ->UserInformation.printMoney(account);
                case 5 -> loop = false;
                default -> ErrorMessage.INPUT.printError();
            }
        }

    }

    public void startTransaction(UserInput  userInput, ErrorMessage errorMessage, Transactions transactions){
        int money = userInput.userInput();
        if(transactions.transaction(account, money)){
           UserInformation.printMoney(account);
        }else{
            errorMessage.printError();
        }
    }



}
