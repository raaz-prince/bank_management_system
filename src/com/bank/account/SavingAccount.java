package com.bank.account;

import com.bank.customer.Customer;
import com.bank.exception.InsufficientBalanceException;
import com.bank.transaction.Transaction;

public class SavingAccount extends Account{

    public SavingAccount(Customer customer) {
        super("saving account", customer);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.getBalance() + amount);
        super.addTransaction(new Transaction("deposit", amount, super.getBalance()));
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if(super.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        super.setBalance(super.getBalance() - amount);
        super.addTransaction(new Transaction("withdrawal", amount, super.getBalance()));
    }
}