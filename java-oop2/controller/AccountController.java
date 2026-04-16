package controller;
import model.Account;
import model.bankservice.Deposit;
import model.bankservice.Transactions;
import model.bankservice.Withdrawal;
import view.message.accountinformation.UserInformation;
import view.message.errormessage.DepositError;
import view.message.errormessage.InputError;
import view.message.errormessage.WithdrawalError;
import view.UserMenu;
import view.message.accountinformation.CheckBalance;
import view.userinput.DepositInput;
import view.userinput.UserInput;
import view.message.errormessage.Error;
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
                case 1 -> startTransaction(new DepositInput(), new DepositError(), new Deposit());
                case 2 -> startTransaction(new WithdrawalInput(), new WithdrawalError(), new Withdrawal());
                case 3-> UserInformation.userinformation(account);
                case 4 ->CheckBalance.printMoney(account);
                case 5 -> loop = false;
                default -> InputError.inputError();
            }
        }

    }

    public void startTransaction(UserInput  userInput, Error error, Transactions transactions){
        int money = userInput.userInput();
        if(transactions.transaction(account, money)){
            CheckBalance.printMoney(account);
        }else{
            error.Error_input();
        }
    }



}
