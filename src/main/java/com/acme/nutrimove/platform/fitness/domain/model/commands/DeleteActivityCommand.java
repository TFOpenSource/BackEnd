package com.acme.nutrimove.platform.fitness.domain.model.commands;

public record DeleteActivityCommand(Long activityId) {
    public DeleteActivityCommand {
        if (activityId == null) throw new IllegalArgumentException("activityId is null");
    }
}
