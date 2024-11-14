package com.acme.nutrimove.platform.backend.sleep.infrastructure.persistence.jpa;

import com.acme.nutrimove.platform.backend.sleep.domain.model.aggregates.Sleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SleepRepository extends JpaRepository<Sleep, Long> {

    // Encuentra todos los registros de sueño por userId
    List<Sleep> findAllByUserId(Long userId);

    // Encuentra un registro de sueño específico por userId y fecha
    Optional<Sleep> findByUserIdAndDate(Long userId, LocalDateTime date);
}
