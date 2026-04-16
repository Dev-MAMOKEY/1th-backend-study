package view.message.accountinformation;
import model.Account;
public  class CheckBalance {
    public static void printMoney(Account account){
        System.out.printf("*현재 금액은 %d원입니다*\n",account.getBalance());
    }
}
