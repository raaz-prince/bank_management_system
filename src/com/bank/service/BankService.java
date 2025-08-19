package com.bank.service;

import com.bank.account.Account;
import com.bank.customer.Customer;

public interface BankService {
    Account openAccount(Customer costumer, String accountType) throws IllegalArgumentException;
    void closeAccount(String accountNo) throws Exception;
    Account getAccount(String accountNo) throws Exception;
    void deposit(String accountNo, double amount) throws Exception;
    void withdraw(String accountNo, double amount) throws Exception;
    void transfer(String fromAcc, String toAcc, double amount) throws Exception;

    Customer addCustomer(String name, String phone, String address);
    Customer getCustomer(int customerId);
    void updateCustomer(int customerId, String name, String phone, String address) throws Exception;
    void deleteCustomer(int customerId) throws Exception;

    void listAccounts();
    void listCustomers();
}
