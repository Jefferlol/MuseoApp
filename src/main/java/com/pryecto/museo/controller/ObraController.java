package com.pryecto.museo.controller;

import com.pryecto.museo.entity.Obra;
import com.pryecto.museo.service.ObraService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {
    private final ObraService obraService;

    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @GetMapping
    public List<Obra> obtenerTodasLasObras() {
        return obraService.obtenerTodasLasObras();
    }

    @PostMapping
    public ResponseEntity<Obra> crearObra(@Valid @RequestBody Obra obra) {
        Obra nuevaObra = obraService.crearObra(obra);
        return ResponseEntity.ok(nuevaObra);
    }
}
