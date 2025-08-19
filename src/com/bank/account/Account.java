package com.bank.account;

import com.bank.customer.Customer;
import com.bank.exception.InsufficientBalanceException;
import com.bank.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private String accountNo;
    private double balance;
    private final String accountType;
    private final List<Transaction> transactions;
    protected Customer customer;

    public Account(String accountType, Customer customer) {
        this.accountNo = AccountNumberGenerator.generateAccountNumber();
        this.balance = 0.0;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
        this.customer = customer;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        return """
           Account{
               accountNo=%s,
               customer=%s
           }
           """.formatted(accountNo, customer);
    }

}
