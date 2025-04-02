package com.pryecto.museo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="artistas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del artista no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La nacionalidad del artista no puede estar vacía")
    private String nacionalidad;

    @JsonIgnore  
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Obra> obras;
}
