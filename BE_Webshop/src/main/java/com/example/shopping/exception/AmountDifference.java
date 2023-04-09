package com.example.shopping.exception;

public class AmountDifference extends RuntimeException {
    public AmountDifference(String message) {
        super(message);
    }
}
