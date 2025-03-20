package com.pryecto.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pryecto.museo.entity.Museo;
import com.pryecto.museo.service.MuseoService;

import java.util.List;

@RestController
@RequestMapping("/museos")
public class MuseoController {

    @Autowired
    private MuseoService museoService;

    @GetMapping
    public List<Museo> obtenerTodos() {
        return museoService.obtenerTodos();
    }

    @PostMapping
    public Museo crearMuseo(@RequestBody Museo museo) {
        return museoService.crearMuseo(museo);
    }
}
