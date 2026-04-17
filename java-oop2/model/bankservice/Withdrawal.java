package model.bankservice;
import model.Account;
// 출금
public class Withdrawal implements Transactions{
    @Override
    public boolean transaction(Account account, int money){
        if(money<=0){
            return false;
        }

        int minusAccount = account.getBalance()-money;
        if(minusAccount<account.MIN_BALABCE){ㅌ
            return false;
        }else{
            account.setBalance(minusAccount);
            return true;
        }
    }
}
