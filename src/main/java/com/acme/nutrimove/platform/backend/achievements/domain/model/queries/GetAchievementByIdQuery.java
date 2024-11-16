package com.acme.nutrimove.platform.backend.achievements.domain.model.queries;

public record GetAchievementByIdQuery(
        Long achievementId,   // ID del logro
        Long userId           // ID del usuario asociado
) {}