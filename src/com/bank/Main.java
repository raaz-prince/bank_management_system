package com.bank;

import com.bank.account.Account;
import com.bank.customer.Customer;
import com.bank.service.BankService;
import com.bank.service.BankServiceImp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankServiceImp();

        while(true) {
            System.out.println("\n===== Smart Bank Menu =====");
            System.out.println("1. Create Customer");
            System.out.println("2. List Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Open Account");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Show Account Details");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Customer Name: ");
                        String name = sc.next();
                        System.out.print("Enter Phone: ");
                        String phone = sc.next();
                        System.out.print("Enter Address: ");
                        String addr = sc.next();
                        Customer c = bankService.addCustomer(name, phone, addr);
                        System.out.println(c);
                        break;

                    case 2:
                        bankService.listCustomers();
                        break;

                    case 3:
                        System.out.print("Enter Customer ID: ");
                        int cid = sc.nextInt();
                        Customer found = bankService.getCustomer(cid);
                        System.out.println(found != null ? found : "Customer not found!");
                        break;

                    case 4:
                        System.out.print("Enter Customer ID: ");
                        int custId = sc.nextInt();
                        System.out.print("Enter account type (1-Saving, 2-Current): ");
                        int type = sc.nextInt();
                        //System.out.print("Enter initial deposit: ");
                        //double bal = sc.nextDouble();
                        Account acc = bankService.openAccount(bankService.getCustomer(custId), type == 1 ? "saving" : "current");
                        System.out.println("Account opened: " + acc);
                        break;

                    case 5:
                        System.out.print("Enter Account Number: ");
                        String accNoD = sc.next();
                        System.out.print("Enter Amount: ");
                        double depAmt = sc.nextDouble();
                        bankService.deposit(accNoD, depAmt);
                        break;

                    case 6:
                        System.out.print("Enter Account Number: ");
                        String accNoW= sc.next();
                        System.out.print("Enter Amount: ");
                        double wAmt = sc.nextDouble();
                        bankService.withdraw(accNoW, wAmt);
                        break;

                    case 7:
                        System.out.print("Enter Account Number: ");
                        String accNo = sc.next();
                        Account a = bankService.getAccount(accNo);
                        System.out.println(a != null ? a : "Account not found!");
                        break;

                    case 8:
                        System.out.println("Exiting... Thank you!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
                } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
