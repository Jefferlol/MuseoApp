package com.pryecto.museo.controller;

import com.pryecto.museo.entity.Sala;
import com.pryecto.museo.service.SalaService;

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
    public ResponseEntity<Sala> obtenerSalaPorId(@PathVariable Long id) {
        Optional<Sala> sala = salaService.obtenerSalaPorId(id);
        return sala.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sala crearSala(@RequestBody Sala sala) {
        return salaService.crearSala(sala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> actualizarSala(@PathVariable Long id, @RequestBody Sala sala) {
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
