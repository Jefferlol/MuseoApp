package com.pryecto.museo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="museos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Museo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String direccion;
    
    @JsonIgnore
    @OneToMany(mappedBy = "museo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sala> salas;
}
