package com.pryecto.museo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "salas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties("obras")  // Evita la recursión infinita
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la Sala no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El tipo de sala no puede estar vacío")
    private String tipo;

    @NotNull(message = "El museo asociado no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "museo_id")
    private Museo museo;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Obra> obras;
}
