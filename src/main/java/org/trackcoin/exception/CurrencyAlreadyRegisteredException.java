package org.trackcoin.exception;

public class CurrencyAlreadyRegisteredException extends RuntimeException {
    public CurrencyAlreadyRegisteredException(String message) {
        super(message);
    }
}
