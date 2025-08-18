package com.bank.exception;

public class AccountInvalidException extends Exception{
    public AccountInvalidException(String message){
        super(message);
    }
}
