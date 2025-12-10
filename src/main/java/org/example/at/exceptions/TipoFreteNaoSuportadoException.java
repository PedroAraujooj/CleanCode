package org.example.at.exceptions;

public class TipoFreteNaoSuportadoException extends RuntimeException {
    public TipoFreteNaoSuportadoException(String message) {
        super(message);
    }
}