package com.pryecto.museo.config;

public class MuseoNotFoundException extends RuntimeException {
    public MuseoNotFoundException(String message) {
        super(message);
    }
}