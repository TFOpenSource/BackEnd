package com.acme.nutrimove.platform.backend.sleep.domain.model.commands;

import com.acme.nutrimove.platform.backend.sleep.domain.model.aggregates.Sleep.Quality;
import java.time.LocalDateTime;

public record CreateSleepCommand(
        Long userId,
        LocalDateTime date,
        int hoursSlept,
        Quality quality
) {}
