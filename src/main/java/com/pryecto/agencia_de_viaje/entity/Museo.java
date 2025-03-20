package com.pryecto.agencia_de_viaje.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "museo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sala> salas;
}
