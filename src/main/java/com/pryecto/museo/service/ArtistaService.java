package com.pryecto.museo.service;

import com.pryecto.museo.entity.Artista;
import com.pryecto.museo.repository.ArtistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {
    private static ArtistaService instance;
    private final ArtistaRepository artistaRepository;

    private ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    
    
    public static synchronized ArtistaService getInstance(ArtistaRepository artistaRepository) {
        if (instance == null) {
            instance = new ArtistaService(artistaRepository);
        }
        return instance;
    }

    public List<Artista> obtenerTodosLosArtistas() {
        return artistaRepository.findAll();
    }

    public Artista crearArtista(Artista artista) {
        return artistaRepository.save(artista);
    }
}
