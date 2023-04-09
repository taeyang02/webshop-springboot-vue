package com.example.shopping.exception;

public class EntityIsEmptyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public EntityIsEmptyException(String message) {
        super(message);
    }
}
