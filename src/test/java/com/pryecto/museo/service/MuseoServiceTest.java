package com.pryecto.museo.service;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pryecto.museo.entity.Museo;
import com.pryecto.museo.repository.MuseoRepository;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class MuseoServiceTest {

    @Mock
    private MuseoRepository museoRepository;

    @InjectMocks
    private MuseoService museoService = MuseoService.getInstance(); // Singleton

    @Test
    void testObtenerTodos() {
        // Simulamos museos en la BD
        Museo museo1 = new Museo();
        museo1.setId(1L);
        museo1.setNombre("Museo Nacional");

        Museo museo2 = new Museo();
        museo2.setId(2L);
        museo2.setNombre("Museo de Arte Moderno");

        when(museoRepository.findAll()).thenReturn(Arrays.asList(museo1, museo2));

        List<Museo> resultado = museoService.obtenerTodos();

        assertEquals(2, resultado.size());
        assertEquals("Museo Nacional", resultado.get(0).getNombre());
    }

    @Test
    void testCrearMuseo() {
        Museo nuevoMuseo = new Museo();
        nuevoMuseo.setNombre("Museo del Futuro");

        when(museoRepository.save(any(Museo.class))).thenReturn(nuevoMuseo);

        Museo resultado = museoService.crearMuseo(nuevoMuseo);

        assertNotNull(resultado);
        assertEquals("Museo del Futuro", resultado.getNombre());
    }
}