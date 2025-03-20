package com.pryecto.agencia_de_viaje.config;



public class PagoNotFoundException extends RuntimeException {
    public PagoNotFoundException(String message) {
        super(message);
    }
}