package com.pryecto.museo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pryecto.museo.entity.Obra;


@Repository
public interface ObraRepository extends JpaRepository<Obra, Long> {}