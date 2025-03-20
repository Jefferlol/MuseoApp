package com.pryecto.agencia_de_viaje.config;



public class ReservaNotFoundException extends RuntimeException {
    public ReservaNotFoundException(String message) {
        super(message);
    }
}