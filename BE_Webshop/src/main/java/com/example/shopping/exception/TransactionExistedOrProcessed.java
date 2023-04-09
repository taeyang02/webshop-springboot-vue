package com.example.shopping.exception;

public class TransactionExistedOrProcessed extends RuntimeException {
    public TransactionExistedOrProcessed(String message) {
        super(message);
    }
}
