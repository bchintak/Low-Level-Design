package com.vendingmachine.exception;

public class InvalidSelectionException
        extends RuntimeException {

    public InvalidSelectionException(
            String message) {

        super(message);
    }
}