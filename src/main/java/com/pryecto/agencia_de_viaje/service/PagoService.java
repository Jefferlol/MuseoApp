package com.pryecto.agencia_de_viaje.service;

import com.pryecto.agencia_de_viaje.config.PagoNotFoundException;
import com.pryecto.agencia_de_viaje.entity.Pago;

import com.pryecto.agencia_de_viaje.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<Pago> obtenerTodosLosPagos() {
        return pagoRepository.findAll();
    }

    public Pago obtenerPagoPorId(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new PagoNotFoundException("Pago no encontrado con id: " + id));
    }

    public Pago crearPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago actualizarPago(Long id, Pago pagoActualizado) {
        Pago pagoExistente = obtenerPagoPorId(id);
        pagoExistente.setMonto(pagoActualizado.getMonto());
        return pagoRepository.save(pagoExistente);
    }

    public void eliminarPago(Long id) {
        Pago pago = obtenerPagoPorId(id);
        pagoRepository.delete(pago);
    }
}