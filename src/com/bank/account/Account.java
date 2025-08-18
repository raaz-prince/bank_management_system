package com.bank.account;

import com.bank.exception.InsufficientBalanceException;
import com.bank.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private String accountNo;
    private double balance;
    private String accountType;
    private final List<Transaction> transactions;

    public Account(String accountType) {
        this.accountNo = AccountNumberGenerator.generateAccountNumber();
        this.balance = 0.0;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }

    public abstract String deposit(double amount);
    public abstract String withdraw(double amount) throws InsufficientBalanceException;

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

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
