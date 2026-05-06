package model.bankservice;
import model.Account;
// 입금
public class Deposit implements Transactions {
    @Override
    public boolean transaction(Account account, int money){
        if(money<=0){
            return false;
        }else{
            int plusAccount = account.getBalance()+money;
            account.setBalance(plusAccount);
            return true;
        }
    }
}
