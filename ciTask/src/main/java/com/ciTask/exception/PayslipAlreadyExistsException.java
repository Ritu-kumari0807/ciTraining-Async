package com.ciTask.exception;

public class PayslipAlreadyExistsException extends RuntimeException {
    public PayslipAlreadyExistsException(String message) {
        super(message);
    }
}
