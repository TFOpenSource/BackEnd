package com.acme.nutrimove.platform.activities.domain.model.queries;

public record GetActivityByIdQuery(Long id) {
    public GetActivityByIdQuery {
        if (id == null) throw new NullPointerException("id is null");
    }
}