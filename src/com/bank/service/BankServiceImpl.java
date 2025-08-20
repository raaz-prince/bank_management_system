package com.bank.service;

import com.bank.account.Account;
import com.bank.account.CurrentAccount;
import com.bank.account.SavingAccount;
import com.bank.customer.Customer;
import com.bank.exception.InsufficientBalanceException;

import java.util.HashMap;
import java.util.Map;

public class BankServiceImpl implements BankService{
    Map<String, Account> accounts = new HashMap<>();
    @Override
    public Account openAccount(Customer customer, String accountType) throws IllegalArgumentException {
        Account account = null;
        if("saving".equalsIgnoreCase(accountType)) {
            account = new SavingAccount(customer);
        } else if("current".equalsIgnoreCase(accountType)) {
            account = new CurrentAccount(customer);
        } else {
            throw new IllegalArgumentException("Invalid account type");
        }
        accounts.put(account.getAccountNo(), account);
        return account;
    }

    @Override
    public void closeAccount(String accountNo) throws Exception {
        Account account = accounts.remove(accountNo);
        if(account == null)
            throw new Exception("Account not found");
        System.out.println("Account successfully deleted. " + accountNo);
    }

    @Override
    public Account getAccount(String accountNo) throws Exception {
        Account account = accounts.get(accountNo);
        if(account == null)
            throw new Exception("Account not found");
        return account;
    }

    @Override
    public void deposit(String accountNo, double amount) throws Exception {
        Account account = accounts.get(accountNo);
        if(account == null)
            throw new Exception("Account not found");
        account.deposit(amount);
        System.out.println("Deposit successful. Current Balance: " + account.getBalance());
    }

    @Override
    public void withdraw(String accountNo, double amount) throws Exception {
        Account account = accounts.get(accountNo);
        if(account == null)
            throw new Exception("Account not found");
        try{
            account.withdraw(amount);
            System.out.println("Withdrawal successful. Current Balance: " + account.getBalance());
        }catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void transfer(String fromAcc, String toAcc, double amount) throws Exception {
        Account from = accounts.get(fromAcc);
        Account to = accounts.get(toAcc);
        if(from == null || to == null)
            throw new Exception("Account not found");
        try{
            from.withdraw(amount);
            to.deposit(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Transferred " + amount + " from " + fromAcc + " to " + toAcc);
    }

    @Override
    public void listAccounts() {
        accounts.values().forEach(System.out::println);
    }

    @Override
    public void showTransactions(String accountNo) throws Exception {
        Account account = accounts.get(accountNo);
        if(account == null)
            throw new Exception("Account not found");
        account.getTransactions().forEach(System.out::println);
    }
}