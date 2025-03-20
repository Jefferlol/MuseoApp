package com.pryecto.agencia_de_viaje.config;

public class MuseoNotFoundException extends RuntimeException {
    public MuseoNotFoundException(String message) {
        super(message);
    }
}