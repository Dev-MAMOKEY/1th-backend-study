package view.message.accountinformation;

import model.Account;

public class UserInformation {
    public static void userinformation(Account account){
        System.out.printf("*계좌번호:%d 이름:%s*\n",account.getAccountNumber(),account.getOwner());
    }
}
