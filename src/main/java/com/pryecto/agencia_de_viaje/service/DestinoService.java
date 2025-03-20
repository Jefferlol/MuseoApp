package com.pryecto.agencia_de_viaje.service;

import com.pryecto.agencia_de_viaje.config.DestinoNotFoundException;
import com.pryecto.agencia_de_viaje.entity.Destino;

import com.pryecto.agencia_de_viaje.repository.DestinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinoService {

    private final DestinoRepository destinoRepository;

    public DestinoService(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    public List<Destino> obtenerTodosLosDestinos() {
        return destinoRepository.findAll();
    }

    public Destino obtenerDestinoPorId(Long id) {
        return destinoRepository.findById(id)
                .orElseThrow(() -> new DestinoNotFoundException("Destino no encontrado con id: " + id));
    }

    public Destino crearDestino(Destino destino) {
        return destinoRepository.save(destino);
    }

    public Destino actualizarDestino(Long id, Destino destinoActualizado) {
        Destino destinoExistente = obtenerDestinoPorId(id);
        destinoExistente.setNombre(destinoActualizado.getNombre());
        destinoExistente.setDescripcion(destinoActualizado.getDescripcion());
        return destinoRepository.save(destinoExistente);
    }

    public void eliminarDestino(Long id) {
        Destino destino = obtenerDestinoPorId(id);
        destinoRepository.delete(destino);
    }
}