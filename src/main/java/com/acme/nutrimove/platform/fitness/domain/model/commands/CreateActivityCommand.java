package com.acme.nutrimove.platform.fitness.domain.model.commands;


public record CreateActivityCommand(String name, String description, String duration,
                                    Long user_id) {

    public CreateActivityCommand {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name cannot be null or empty");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("description cannot be null or empty");
        if (duration == null || duration.isBlank()) throw new IllegalArgumentException("duration cannot be null or empty");
        if (user_id == null) throw new IllegalArgumentException("user_id cannot be null");

    }
}