package com.pryecto.agencia_de_viaje.config;



public class DestinoNotFoundException extends RuntimeException {
    public DestinoNotFoundException(String message) {
        super(message);
    }
}