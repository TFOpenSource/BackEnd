package com.acme.nutrimove.platform.backend.achievements.interfaces.rest.resources;

import java.time.LocalDate;

public record AchievementResource(
        Long id,               // ID del logro
        Long userId,           // ID del usuario al que pertenece el logro
        String achievement,    // Descripción del logro
        LocalDate date         // Fecha del logro
) {}