package com.pryecto.agencia_de_viaje.controller;

import com.pryecto.agencia_de_viaje.config.DestinoNotFoundException;
import com.pryecto.agencia_de_viaje.entity.Destino;

import com.pryecto.agencia_de_viaje.service.DestinoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    private final DestinoService destinoService;

    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @GetMapping
    public List<Destino> obtenerTodosLosDestinos() {
        return destinoService.obtenerTodosLosDestinos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> obtenerDestinoPorId(@PathVariable Long id) {
        Destino destino = destinoService.obtenerDestinoPorId(id);
        return ResponseEntity.ok(destino);
    }

    @PostMapping
    public ResponseEntity<Destino> crearDestino(@RequestBody Destino destino) {
        Destino nuevoDestino = destinoService.crearDestino(destino);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDestino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destino> actualizarDestino(@PathVariable Long id, @RequestBody Destino destinoActualizado) {
        Destino destino = destinoService.actualizarDestino(id, destinoActualizado);
        return ResponseEntity.ok(destino);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDestino(@PathVariable Long id) {
        destinoService.eliminarDestino(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(DestinoNotFoundException.class)
    public ResponseEntity<String> manejarDestinoNoEncontrado(DestinoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}