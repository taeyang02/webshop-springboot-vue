package com.example.shopping.exception;

public enum ExceptionType {
    ENTITY_NOT_FOUND("not.found"),
    ENTITY_ALREADY_EXIST("already.exist"),
    DUPLICATE_ENTITY("duplicate"),
    ENTITY_EXCEPTION("exception"),
	OCR_EXCEPTION("exception.ocr"),
	UNAUTHENTICATED("unauthenticated");

    String value;

    ExceptionType(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }
}
