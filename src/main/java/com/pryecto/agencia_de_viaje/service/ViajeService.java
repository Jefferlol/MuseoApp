package com.pryecto.agencia_de_viaje.service;

import com.pryecto.agencia_de_viaje.config.DestinoNotFoundException;
import com.pryecto.agencia_de_viaje.config.ViajeNotFoundException;
import com.pryecto.agencia_de_viaje.entity.Viaje;
import com.pryecto.agencia_de_viaje.entity.Destino;

import com.pryecto.agencia_de_viaje.repository.ViajeRepository;
import com.pryecto.agencia_de_viaje.repository.DestinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeService {

    private final ViajeRepository viajeRepository;
    private final DestinoRepository destinoRepository;

    public ViajeService(ViajeRepository viajeRepository, DestinoRepository destinoRepository) {
        this.viajeRepository = viajeRepository;
        this.destinoRepository = destinoRepository;
    }

    public List<Viaje> obtenerTodosLosViajes() {
        return viajeRepository.findAll();
    }

    public Viaje obtenerViajePorId(Long id) {
        return viajeRepository.findById(id)
                .orElseThrow(() -> new ViajeNotFoundException("Viaje no encontrado con id: " + id));
    }

    public Viaje crearViaje(Viaje viaje) {
        // Verificar si el destino existe
        Destino destino = destinoRepository.findById(viaje.getDestino().getId())
                .orElseThrow(() -> new DestinoNotFoundException("Destino no encontrado con id: " + viaje.getDestino().getId()));

        viaje.setDestino(destino); // Asignar el destino existente al viaje
        return viajeRepository.save(viaje);
    }

    public Viaje actualizarViaje(Long id, Viaje viajeActualizado) {
        Viaje viajeExistente = obtenerViajePorId(id);

        // Verificar si el destino existe
        Destino destino = destinoRepository.findById(viajeActualizado.getDestino().getId())
                .orElseThrow(() -> new DestinoNotFoundException("Destino no encontrado con id: " + viajeActualizado.getDestino().getId()));

        viajeExistente.setNombre(viajeActualizado.getNombre());
        viajeExistente.setDestino(destino); // Asignar el destino existente al viaje
        return viajeRepository.save(viajeExistente);
    }

    public void eliminarViaje(Long id) {
        Viaje viaje = obtenerViajePorId(id);
        viajeRepository.delete(viaje);
    }
}