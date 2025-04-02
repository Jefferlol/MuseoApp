package com.pryecto.museo.service;

import com.pryecto.museo.entity.Sala;
import com.pryecto.museo.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    private static SalaService instance;
    private final SalaRepository salaRepository;

    private SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    // Método para obtener la única instancia de la clase (Singleton)
    public static synchronized SalaService getInstance(SalaRepository salaRepository) {
        if (instance == null) {
            instance = new SalaService(salaRepository);
        }
        return instance;
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
