package com.pryecto.museo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="obras")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String descripcion;
    private int anio;
    
    @ManyToOne
    @JoinColumn(name = "sala_id")
    @JsonIgnoreProperties("obras")  // Evita la recursión infinita
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    @JsonIgnoreProperties("obras")  // Evita la recursión infinita
    private Artista artista;
}
