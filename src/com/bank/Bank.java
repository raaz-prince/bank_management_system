package com.bank;


import com.bank.account.Account;
import com.bank.customer.Customer;
import com.bank.service.BankService;
import com.bank.service.BankServiceImpl;
import com.bank.service.CustomerService;
import com.bank.service.CustomerServiceImpl;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        System.out.println("\n-------------------------------Welcome To Bank------------------------");
        while(true) {
            System.out.println("\nOptions:- ");
            System.out.println("1. Create Customer");
            System.out.println("2. Open Account");
            System.out.println("3. Customer Management");
            System.out.println("4. Bank Management");
            System.out.println("5. List Customers");
            System.out.println("6. List Accounts");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("\nEnter Customer Name: ");
                        String name = scanner.next();
                        System.out.print("Enter Phone: ");
                        String phone = scanner.next();
                        System.out.print("Enter Address: ");
                        String address = scanner.next();
                        Customer customer = customerService.addCustomer(name, phone, address);
                        System.out.println("Customer successfully created: " + customer);
                    }
                    case 2 -> {
                        System.out.print("\nEnter Customer Id: ");
                        int custId = scanner.nextInt();
                        System.out.print("Enter account type (1-saving, 2-current): ");
                        int type = scanner.nextInt();
                        Account account = bankService.openAccount(customerService.getCustomer(custId), type == 1 ? "saving" : "current");
                        System.out.println("Account successfully created: " + account);
                    }
                    case 3 -> {
                        int customerChoice;
                        do {
                            System.out.println("\n1. Search Customer");
                            System.out.println("2. Delete Customer");
                            System.out.println("3. Update Customer");
                            System.out.println("0. Exit");
                            System.out.print("Enter choice: ");
                            System.out.flush();
                            customerChoice = scanner.nextInt();
                            System.out.flush();

                            if (customerChoice == 0) {
                                System.out.println("Returning to main menu...");
                                break;
                            }

                            try {
                                System.out.print("Enter Customer Id: ");
                                int custId = scanner.nextInt();
                                Customer customer = customerService.getCustomer(custId);

                                switch (customerChoice) {
                                    case 1 -> System.out.println(customer);
                                    case 2 -> {
                                        String str = customerService.deleteCustomer(custId);
                                        System.out.println(str);
                                    }
                                    case 3 -> {
                                        int updateChoice;
                                        do {
                                            System.out.println("\n1. Update Name");
                                            System.out.println("2. Update Phone");
                                            System.out.println("3. Update Address");
                                            System.out.println("4. update All");
                                            System.out.println("0. Exit");
                                            System.out.print("Enter Choice: ");
                                            updateChoice = scanner.nextInt();
                                            switch (updateChoice) {
                                                case 1 -> {
                                                    System.out.print("Enter Updated Name: ");
                                                    String name = scanner.next();
                                                    customer = customerService.updateName(custId, name);
                                                    System.out.println("Updated Customer: " + customer);
                                                }
                                                case 2 -> {
                                                    System.out.print("Enter Updated Phone: ");
                                                    String phone = scanner.next();
                                                    customer = customerService.updatePhone(custId, phone);
                                                    System.out.println("Updated Customer: " + customer);
                                                }
                                                case 3 -> {
                                                    System.out.print("Enter Updated Address: ");
                                                    String address = scanner.next();
                                                    customer = customerService.updateAddress(custId, address);
                                                    System.out.println("Updated Customer: " + customer);
                                                }
                                                case 4 -> {
                                                    System.out.print("Enter Name: ");
                                                    String name = scanner.next();
                                                    System.out.print("Enter Updated Phone: ");
                                                    String phone = scanner.next();
                                                    System.out.print("Enter Updated Address: ");
                                                    String address = scanner.next();
                                                    customer = customerService.updateCustomer(custId, name, phone, address);
                                                    System.out.println("Updated Customer: " + customer);
                                                }
                                                case 0 -> System.out.println("Returning to previous menu....");
                                                default -> System.out.println("Invalid update option!");
                                            }
                                        }while (updateChoice != 0);
                                    }
                                    default -> System.out.println("Invalid Customer Option!");
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } while (customerChoice != 0);
                    }
                    case 4 -> {
                        int bankChoice;
                        do {
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Transfer");
                            System.out.println("4. Show Account Details");
                            System.out.println("5. Transactions history");
                            System.out.println("6. Delete Account");
                            System.out.println("0. Exit");
                            System.out.print("Enter choice: ");
                            System.out.flush();
                            bankChoice = scanner.nextInt();
                            System.out.flush();
                            if(bankChoice == 0) {
                                System.out.println("Returning to main menu...");
                                break;
                            }
                            try {
                                System.out.print("Enter Account Number: ");
                                String accNo = scanner.next();
                                switch (bankChoice) {
                                    case 1 -> {
                                        System.out.print("Enter amount: ");
                                        double amount = scanner.nextDouble();
                                        bankService.deposit(accNo, amount);
                                    }
                                    case 2 -> {
                                        System.out.println("Enter amount: ");
                                        double amount = scanner.nextDouble();
                                        bankService.withdraw(accNo, amount);
                                    }
                                    case 3 -> {
                                        System.out.print("Enter Receiver Account Number: ");
                                        String receiverAcc = scanner.next();
                                        System.out.print("Enter Amount to Transfer: ");
                                        double amount = scanner.nextDouble();
                                        bankService.transfer(accNo, receiverAcc, amount);
                                    }
                                    case 4 -> {
                                        Account account = bankService.getAccount(accNo);
                                        System.out.println(account);
                                    }
                                    case 5 -> bankService.showTransactions(accNo);
                                    case 6 -> bankService.closeAccount(accNo);
                                    default -> System.out.println("Invalid Customer Option!");
                                }
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } while (bankChoice != 0);
                    }
                    case 5 -> {
                        customerService.listCustomers();
                    }
                    case 6 -> {
                        bankService.listAccounts();
                    }
                    case 0 -> {
                        System.out.println("Exiting... Thank you!");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid Choice!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
