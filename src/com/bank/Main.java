package com.bank;

import com.bank.account.Account;
import com.bank.account.AccountNumberGenerator;
import com.bank.account.CurrentAccount;
import com.bank.account.SavingAccount;
import com.bank.exception.InsufficientBalanceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Account> accounts = new HashMap<>();
        System.out.println("-------------------------------Welcome To Bank----------------------------------------");
        int option = 0;
        do {
            System.out.println("\nOptions:- ");
            System.out.println("1. Open a new saving account");
            System.out.println("2. Open a current account");
            System.out.println("3. Check balance");
            System.out.println("4. Deposit amount");
            System.out.println("5. Withdraw amount");
            System.out.println("6. View transactions");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            option = Integer.parseInt(br.readLine());

            switch (option) {
                case 1: {
                    Account account = new SavingAccount();
                    accounts.put(account.getAccountNo(), account);
                    System.out.println("Saving account created. Account No: "+account.getAccountNo());
                    break;
                }

                case 2: {
                    Account account = new CurrentAccount();
                    accounts.put(account.getAccountNo(), account);
                    System.out.println("Current account created. Account No: "+ account.getAccountNo());
                    break;
                }

                case 3: {
                    System.out.print("Enter account number: ");
                    String accNo = br.readLine();
                    Account acc = accounts.get(accNo);
                    if(acc != null) {
                        System.out.println("Balance: " + acc.getBalance());
                    } else {
                        System.err.println("Account not found");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter account number: ");
                    String accNo = br.readLine();
                    Account acc = accounts.get(accNo);
                    if (acc != null) {
                        System.out.print("Enter deposit amount: ");
                        double amt = Double.parseDouble(br.readLine());
                        System.out.println(acc.deposit(amt));
                    } else {
                        System.err.println("Account not found!");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Enter account number: ");
                    String accNo = br.readLine();
                    Account acc = accounts.get(accNo);
                    if (acc != null) {
                        System.out.print("Enter withdraw amount: ");
                        double amt = Double.parseDouble(br.readLine());
                        try {
                            System.out.println(acc.withdraw(amt));
                        } catch (InsufficientBalanceException e) {
                            System.err.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                }
                case 6: {
                    System.out.print("Enter account number: ");
                    String accNo = br.readLine();
                    Account acc = accounts.get(accNo);
                    if (acc != null) {
                        acc.getTransactions().forEach(System.out::println);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                }
                case 0:
                    System.out.println("Thank you for using our Bank!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while(option != 0);
    }
}
