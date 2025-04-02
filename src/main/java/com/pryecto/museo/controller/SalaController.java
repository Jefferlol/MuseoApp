package com.pryecto.museo.controller;

import com.pryecto.museo.entity.Sala;
import com.pryecto.museo.service.SalaService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public List<Sala> obtenerTodasLasSalas() {
        return salaService.obtenerTodasLasSalas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> obtenerSalaPorId(@Valid @PathVariable Long id) {
        Optional<Sala> sala = salaService.obtenerSalaPorId(id);
        return sala.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sala> crearSala(@Valid @RequestBody Sala sala) {
        Sala nuevaSala = salaService.crearSala(sala);
        return ResponseEntity.ok(nuevaSala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> actualizarSala(@PathVariable Long id, @Valid @RequestBody Sala sala) {
        try {
            Sala salaActualizada = salaService.actualizarSala(id, sala);
            return ResponseEntity.ok(salaActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSala(@PathVariable Long id) {
        salaService.eliminarSala(id);
        return ResponseEntity.noContent().build();
    }
}
