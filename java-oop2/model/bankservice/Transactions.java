package model.bankservice;

import model.Account;

public interface Transactions {
    public boolean transaction(Account account, int money);
}
