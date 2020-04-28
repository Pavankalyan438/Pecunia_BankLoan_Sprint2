package com.capgemini.pecunia.exception;

public class BankAccountNotFound extends RuntimeException 
{
    public BankAccountNotFound(String exception) {
        super(exception);
    }
}