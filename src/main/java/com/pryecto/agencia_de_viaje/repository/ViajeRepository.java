package com.pryecto.agencia_de_viaje.repository;

import com.pryecto.agencia_de_viaje.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {}