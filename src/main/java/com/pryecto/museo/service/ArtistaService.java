package com.pryecto.museo.service;

import com.pryecto.museo.entity.Artista;
import com.pryecto.museo.repository.ArtistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {
    private final ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public List<Artista> obtenerTodosLosArtistas() {
        return artistaRepository.findAll();
    }

    public Artista crearArtista(Artista artista) {
        return artistaRepository.save(artista);
    }
}
