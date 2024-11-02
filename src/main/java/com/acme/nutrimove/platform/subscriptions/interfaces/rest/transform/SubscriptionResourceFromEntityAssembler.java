package com.acme.nutrimove.platform.subscriptions.interfaces.rest.transform;

import com.acme.nutrimove.platform.subscriptions.domain.model.aggregates.Subscription;
import com.acme.nutrimove.platform.subscriptions.interfaces.rest.resources.SubscriptionResource;

public class SubscriptionResourceFromEntityAssembler {
    public static SubscriptionResource toResourceFromEntity(Subscription subscription) {
        return new SubscriptionResource(subscription.getId(), subscription.getDescription(), subscription.getPrice(), subscription.getMonthDuration(), subscription.getTrial(), subscription.getUserId());
    }
}
