package com.example.shopping.exception;

public class UnsupportedPaymentTypeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public UnsupportedPaymentTypeException(String message) {
        super(message);
    }
}
