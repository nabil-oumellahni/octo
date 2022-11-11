package com.octoproject.exception;

public class CompteNonExistantException extends Exception {

    private static final long serialVersionUID = 1L;

    public CompteNonExistantException() {
    }

    public CompteNonExistantException(String message) {
        super(message);
    }
}
