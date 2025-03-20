package com.pryecto.agencia_de_viaje.controller;

import com.pryecto.agencia_de_viaje.config.DestinoNotFoundException;
import com.pryecto.agencia_de_viaje.config.ViajeNotFoundException;
import com.pryecto.agencia_de_viaje.entity.Viaje;


import com.pryecto.agencia_de_viaje.service.ViajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viajes")
public class ViajeController {

    private final ViajeService viajeService;

    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping
    public List<Viaje> obtenerTodosLosViajes() {
        return viajeService.obtenerTodosLosViajes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viaje> obtenerViajePorId(@PathVariable Long id) {
        Viaje viaje = viajeService.obtenerViajePorId(id);
        return ResponseEntity.ok(viaje);
    }

    @PostMapping
    public ResponseEntity<Viaje> crearViaje(@RequestBody Viaje viaje) {
        Viaje nuevoViaje = viajeService.crearViaje(viaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoViaje);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viaje> actualizarViaje(@PathVariable Long id, @RequestBody Viaje viajeActualizado) {
        Viaje viaje = viajeService.actualizarViaje(id, viajeActualizado);
        return ResponseEntity.ok(viaje);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarViaje(@PathVariable Long id) {
        viajeService.eliminarViaje(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ViajeNotFoundException.class)
    public ResponseEntity<String> manejarViajeNoEncontrado(ViajeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(DestinoNotFoundException.class)
    public ResponseEntity<String> manejarDestinoNoEncontrado(DestinoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}