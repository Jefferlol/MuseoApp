package com.pryecto.agencia_de_viaje.service;

import com.pryecto.agencia_de_viaje.entity.Sala;
import com.pryecto.agencia_de_viaje.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<Sala> obtenerTodasLasSalas() {
        return salaRepository.findAll();
    }

    public Optional<Sala> obtenerSalaPorId(Long id) {
        return salaRepository.findById(id);
    }

    public Sala crearSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public Sala actualizarSala(Long id, Sala salaActualizada) {
        return salaRepository.findById(id)
                .map(sala -> {
                    sala.setNombre(salaActualizada.getNombre());
                    sala.setTipo(salaActualizada.getTipo());
                    sala.setMuseo(salaActualizada.getMuseo());
                    return salaRepository.save(sala);
                }).orElseThrow(() -> new RuntimeException("Sala no encontrada con ID: " + id));
    }

    public void eliminarSala(Long id) {
        salaRepository.deleteById(id);
    }
}
