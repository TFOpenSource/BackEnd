package com.acme.nutrimove.platform.backend.achievements.interfaces.rest.resources;

import java.time.LocalDate;

public record UpdateAchievementResource(
        Long achievementId,   // ID del logro
        Long userId,          // ID del usuario asociado
        String achievement,   // Descripción del logro
        LocalDate date        // Fecha del logro
) {}
