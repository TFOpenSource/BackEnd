package com.acme.nutrimove.platform.backend.achievements.domain.model.commands;

import java.time.LocalDate;

public record CreateAchievementCommand(
        Long userId,           // ID del usuario asociado (FK)
        String achievement,     // Descripción del logro
        LocalDate date          // Fecha del logro
) {}
