package com.acme.nutrimove.platform.subscriptions.domain.model.queries;

public record GetSubscriptionByIdQuery(Long id) {
    public GetSubscriptionByIdQuery {
        if (id == null) throw new NullPointerException("id is null");
    }
}
