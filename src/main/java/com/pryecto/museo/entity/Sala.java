package com.pryecto.museo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="salas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties("obras")  // Evita la recursión infinita
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name = "museo_id")
    private Museo museo;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Obra> obras;
}
