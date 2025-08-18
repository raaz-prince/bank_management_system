package com.bank.transaction;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private LocalDate date;
    private String type;
    private double amount;
    private double totalBalance;

    public Transaction(String type, double amount, double totalBalance) {
        this.date = LocalDate.now();
        this.type = type;
        this.amount = amount;
        this.totalBalance = totalBalance;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    @Override
    public String toString() {
        return date + " | " + type + " | " + amount + " | Balance: " + totalBalance;
    }
}