package com.example.shopping.exception;

public class QuartzException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public QuartzException(String message) {
        super(message);
    }
}
