package com.pryecto.agencia_de_viaje.repository;

import com.pryecto.agencia_de_viaje.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {}