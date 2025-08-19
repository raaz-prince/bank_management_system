package com.bank.service;

import com.bank.account.Account;
import com.bank.account.CurrentAccount;
import com.bank.account.SavingAccount;
import com.bank.customer.Customer;
import com.bank.exception.InsufficientBalanceException;

import java.util.HashMap;
import java.util.Map;

public class BankServiceImp implements BankService{
    private final Map<String, Account> accounts = new HashMap<>();
    private final Map<Integer, Customer> customers = new HashMap<>();

    @Override
    public Account openAccount(Customer customer, String accountType) throws IllegalArgumentException {
        Account acc;
        if("saving".equalsIgnoreCase(accountType)) {
            acc = new SavingAccount(customer);
        } else if ("current".equalsIgnoreCase(accountType)) {
            acc = new CurrentAccount(customer);
        } else {
            throw new IllegalArgumentException("Invalid account type");
        }
        accounts.put(acc.getAccountNo(), acc);
        customers.put(customer.getCustomerId(), customer);
        System.out.println("Account created. " + acc);
        return acc;
    }

    @Override
    public void closeAccount(String accountNo) throws Exception {
        Account account = accounts.remove(accountNo);
        if(account == null)
            throw new Exception("Account not found");
        System.out.println("Closed account: " + accountNo);
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
        System.out.println("Deposit Successful. Current Balance: " + account.getBalance());
    }

    @Override
    public void withdraw(String accountNo, double amount) throws Exception {
        Account account = accounts.get(accountNo);
        if(account == null)
            throw new Exception("Account not found");
        try {
            account.withdraw(amount);
            System.out.println("Withdrawal Successful. Balance: " + account.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void transfer(String fromAcc, String toAcc, double amount) throws Exception {
        Account from = accounts.get(fromAcc);
        Account to = accounts.get(toAcc);
        if(from == null || to == null)
            throw new Exception("Account not found!");
        try{
            from.withdraw(amount);
            to.deposit(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Transferred " + amount + " from " + fromAcc + " to " + toAcc);
    }

    @Override
    public void showTranscations(String accNoT) throws Exception{
        Account account = accounts.get(accNoT);
        if(account == null)
            throw new Exception("Account not found");
        account.getTransactions().forEach(System.out::println);
    }

    @Override
    public Customer addCustomer(String name, String phone, String address) {
        Customer c = new Customer(name, phone, address);
        customers.put(c.getCustomerId(), c);
        System.out.println("Customer created: ");
        return c;
    }

    @Override
    public Customer getCustomer(int customerId) throws Exception {
        Customer customer = customers.get(customerId);
        if(customer == null)
            throw new Exception("Customer doesn't exist");
        return customer;
    }

    @Override
    public void updateCustomer(int customerId, String name, String phone, String address) throws Exception {
        Customer c = customers.get(customerId);
        if(c == null)
            throw new Exception("Customer not found");
        c.setName(name);
        c.setPhone(phone);
        c.setAddress(address);
    }

    @Override
    public void deleteCustomer(int customerId) throws Exception {
        Customer customer = customers.remove(customerId);
        if(customer == null)
            throw new Exception("Customer not found");
        System.out.println("Customer deleted: " + customerId);
    }

    @Override
    public void listAccounts() {
        accounts.values().forEach(System.out::println);
    }

    @Override
    public void listCustomers() {
        customers.values().forEach(System.out::println);
    }
}
