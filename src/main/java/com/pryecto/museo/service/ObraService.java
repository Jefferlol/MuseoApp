package com.pryecto.museo.service;

import com.pryecto.museo.entity.Obra;
import com.pryecto.museo.repository.ObraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {
    private static ObraService instance;
    private final ObraRepository obraRepository;

    private ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    
    public static synchronized ObraService getInstance(ObraRepository obraRepository) {
        if (instance == null) {
            instance = new ObraService(obraRepository);
        }
        return instance;
    }

    public List<Obra> obtenerTodasLasObras() {
        return obraRepository.findAll();
    }

    public Obra crearObra(Obra obra) {
        return obraRepository.save(obra);
    }
}
