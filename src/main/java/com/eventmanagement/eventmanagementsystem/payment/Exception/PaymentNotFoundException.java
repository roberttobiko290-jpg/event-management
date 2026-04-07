package com.eventmanagement.eventmanagementsystem.payment.Exception;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(String message) {
        super(message);
    }
}
