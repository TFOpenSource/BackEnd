package com.acme.nutrimove.platform.fitness.interfaces.rest.resources;

public record ActivityResource(Long id, String name, String description, Integer duration, Long userId ) {
}
