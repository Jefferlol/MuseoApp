package com.pryecto.museo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pryecto.museo.entity.Museo;


@Repository
public interface MuseoRepository extends JpaRepository<Museo, Long> {}