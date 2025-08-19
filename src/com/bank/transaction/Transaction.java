package com.bank.transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String date;
    private String type;
    private double amount;
    private double totalBalance;

    public Transaction(String type, double amount, double totalBalance) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm");
        this.date = LocalDateTime.now().format(formatter);
        this.type = type;
        this.amount = amount;
        this.totalBalance = totalBalance;
    }

    public String getDate() {
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