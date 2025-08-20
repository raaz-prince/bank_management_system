package com.bank.service;

import com.bank.account.Account;
import com.bank.customer.Customer;

public interface BankService {
    Account openAccount(Customer customer, String accountType) throws IllegalArgumentException;
    void closeAccount(String accountNo) throws Exception;
    Account getAccount(String accountNo) throws Exception;
    void deposit(String accountNo, double amount) throws Exception;
    void withdraw(String accountNo, double amount) throws Exception;
    void transfer(String fromAcc, String toAcc, double amount) throws Exception;
    void listAccounts();

    void showTransactions(String accountNo) throws Exception;
}