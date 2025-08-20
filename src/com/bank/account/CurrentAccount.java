package com.bank.account;

import com.bank.customer.Customer;
import com.bank.exception.InsufficientBalanceException;
import com.bank.transaction.Transaction;

public class CurrentAccount extends Account{
    private double overdraftLimit;

    public CurrentAccount(Customer customer) {
        super("current account", customer);
        this.overdraftLimit = 1000;
    }

    public CurrentAccount(double overdraftLimit, Customer customer) {
        super("current account", customer);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.getBalance() + amount);
        super.addTransaction(new Transaction("deposit", amount, super.getBalance()));
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if(super.getBalance() + overdraftLimit < amount) {
            throw new InsufficientBalanceException("Overdraft Limit Reached");
        }
        super.setBalance(super.getBalance() - amount);
        super.addTransaction(new Transaction("withdrawal", amount, super.getBalance()));
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}