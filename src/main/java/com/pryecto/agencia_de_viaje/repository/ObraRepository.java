package com.pryecto.agencia_de_viaje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pryecto.agencia_de_viaje.entity.Obra;


@Repository
public interface ObraRepository extends JpaRepository<Obra, Long> {}