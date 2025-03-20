package com.pryecto.museo.controller;

import com.pryecto.museo.entity.Artista;
import com.pryecto.museo.service.ArtistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {
    private final ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    @GetMapping
    public List<Artista> obtenerTodosLosArtistas() {
        return artistaService.obtenerTodosLosArtistas();
    }

    @PostMapping
    public ResponseEntity<Artista> crearArtista(@RequestBody Artista artista) {
        Artista nuevoArtista = artistaService.crearArtista(artista);
        return ResponseEntity.ok(nuevoArtista);
    }
}
