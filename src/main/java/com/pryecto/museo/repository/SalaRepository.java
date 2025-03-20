package com.pryecto.museo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pryecto.museo.entity.Sala;


@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {}