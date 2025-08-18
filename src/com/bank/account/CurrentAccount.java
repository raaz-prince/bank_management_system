package com.bank.account;

import com.bank.exception.InsufficientBalanceException;
import com.bank.transaction.Transaction;

public class CurrentAccount extends Account{
    private double overdraftLimit;

    public CurrentAccount() {
        super("current account");
        this.overdraftLimit = 1000;
    }

    public CurrentAccount(double overdraftLimit){
        super("current account");
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String deposit(double amount) {
        super.setBalance(super.getBalance() + amount);
        super.addTransaction(new Transaction("deposit", amount, super.getBalance()));
        return "Amount successfully added. Current Balance: " + super.getBalance();
    }

    @Override
    public String withdraw(double amount) throws InsufficientBalanceException {
        if(super.getBalance() + overdraftLimit < amount) {
            throw new InsufficientBalanceException("overdraft limit exceeded");
        }
        super.setBalance(super.getBalance() - amount);
        addTransaction(new Transaction("withdrawal", amount, super.getBalance()));
        return "Withdrawal successful. Current Balance: " + super.getBalance();
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit){
        this.overdraftLimit = overdraftLimit;
    }
}
