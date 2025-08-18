package com.bank.account;

import com.bank.exception.InsufficientBalanceException;
import com.bank.transaction.Transaction;

public class SavingAccount extends Account{
    public SavingAccount() {
        super("saving account");
    }
    @Override
    public String deposit(double amount) {
        super.setBalance(super.getBalance() + amount);
        super.addTransaction(new Transaction("deposit", amount, super.getBalance()));
        return "amount successfully added. Current Balance "+super.getBalance();
    }

    @Override
    public String withdraw(double amount) throws InsufficientBalanceException {
        if(super.getBalance() < amount) {
            throw new InsufficientBalanceException("insufficient balance");
        }
        super.setBalance(super.getBalance() - amount);
        super.addTransaction(new Transaction("withdrawal", amount, super.getBalance()));
        return "withdrawal successful. Current Balance " + super.getBalance();
    }
}
