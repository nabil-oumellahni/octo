package com.octoproject.exception;

import java.io.Serial;

public class SoldeDisponibleInsuffisantException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public SoldeDisponibleInsuffisantException() {
    }

    public SoldeDisponibleInsuffisantException(String message) {
        super(message);
    }
}
