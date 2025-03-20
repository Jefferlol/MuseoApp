package com.pryecto.agencia_de_viaje.repository;

import com.pryecto.agencia_de_viaje.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Long> {}