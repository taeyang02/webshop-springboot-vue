package com.example.shopping.exception;

public class PaymentFail extends RuntimeException {
    public PaymentFail(String message) {
        super(message);
    }
}
