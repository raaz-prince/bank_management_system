package com.bank.account;

public class AccountNumberGenerator {
    private static int ac = 1;

    public static String generateAccountNumber() {
        String s = String.format("%08d", ac);
        ac++;
        return "SBMS"+s;
    }
}
