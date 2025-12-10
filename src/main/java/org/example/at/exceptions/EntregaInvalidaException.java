package org.example.at.exceptions;

public class EntregaInvalidaException extends RuntimeException {
    public EntregaInvalidaException(String message) {
        super(message);
    }
}