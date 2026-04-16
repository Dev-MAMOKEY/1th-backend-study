package model.bankservice;
import model.Account;
// 출금
public class Withdrawal implements Transactions{
    @Override
    public boolean transaction(Account account, int money){
        int minusAccount = account.getBalance()-money;
        if(minusAccount<=account.MIN_BALABCE){
            return false;
        }else{
            account.setBalance(minusAccount);
            return true;
        }
    }
}
