package com.pryecto.agencia_de_viaje.service;

import com.pryecto.agencia_de_viaje.config.ReservaNotFoundException;
import com.pryecto.agencia_de_viaje.entity.Reserva;

import com.pryecto.agencia_de_viaje.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    public Reserva obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException("Reserva no encontrada con id: " + id));
    }

    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva actualizarReserva(Long id, Reserva reservaActualizada) {
        Reserva reservaExistente = obtenerReservaPorId(id);
        reservaExistente.setUsuario(reservaActualizada.getUsuario());
        reservaExistente.setViaje(reservaActualizada.getViaje());
        return reservaRepository.save(reservaExistente);
    }

    public void eliminarReserva(Long id) {
        Reserva reserva = obtenerReservaPorId(id);
        reservaRepository.delete(reserva);
    }
}