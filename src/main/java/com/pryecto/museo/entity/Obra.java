package com.pryecto.museo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    
    @NotBlank(message = "El titulo de la obra no puede ir vacio")
    private String titulo;
    @NotBlank(message = "La descripcion de la obra no puede ir vacio")
    private String descripcion;
    private int anio;
    
    @NotNull(message = "La sala asociada no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "sala_id")
    @JsonIgnoreProperties("obras")  // Evita la recursión infinita
    private Sala sala;
    
    @NotNull(message = "La sala asociada no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "artista_id")
    @JsonIgnoreProperties("obras")  // Evita la recursión infinita
    private Artista artista;
}
