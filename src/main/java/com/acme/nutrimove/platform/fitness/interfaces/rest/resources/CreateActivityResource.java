package com.acme.nutrimove.platform.fitness.interfaces.rest.resources;

public record CreateActivityResource(String name, String description, String duration, Long userId ) {
public CreateActivityResource {
    if (name == null )throw new NullPointerException("name cannot be null");
    if (description == null )throw new NullPointerException("description cannot be null");
    if (duration == null )throw new NullPointerException("duration cannot be null");
    if (userId == null )throw new NullPointerException("userId cannot be null");

}
}
