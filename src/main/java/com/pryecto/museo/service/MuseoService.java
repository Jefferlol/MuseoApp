package com.pryecto.museo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pryecto.museo.entity.Museo;
import com.pryecto.museo.repository.MuseoRepository;

import java.util.List;

@Service
public class MuseoService {

    private static MuseoService instance;

    @Autowired
    private MuseoRepository museoRepository;

    private MuseoService() {} // Constructor privado

    public static synchronized MuseoService getInstance() {
        if (instance == null) {
            instance = new MuseoService();
        }
        return instance;
    }

    public List<Museo> obtenerTodos() {
        return museoRepository.findAll();
    }

    public Museo crearMuseo(Museo museo) {
        return museoRepository.save(museo);
    }
}
