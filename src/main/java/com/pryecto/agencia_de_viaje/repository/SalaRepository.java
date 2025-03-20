package com.pryecto.agencia_de_viaje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pryecto.agencia_de_viaje.entity.Sala;


@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {}