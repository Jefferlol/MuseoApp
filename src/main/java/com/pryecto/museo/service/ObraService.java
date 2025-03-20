package com.pryecto.museo.service;

import com.pryecto.museo.entity.Obra;
import com.pryecto.museo.repository.ObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {
    private final ObraRepository obraRepository;

    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public List<Obra> obtenerTodasLasObras() {
        return obraRepository.findAll();
    }

    public Obra crearObra(Obra obra) {
        return obraRepository.save(obra);
    }
}
