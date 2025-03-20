package com.pryecto.agencia_de_viaje.config;



public class ViajeNotFoundException extends RuntimeException {
    public ViajeNotFoundException(String message) {
        super(message);
    }
}