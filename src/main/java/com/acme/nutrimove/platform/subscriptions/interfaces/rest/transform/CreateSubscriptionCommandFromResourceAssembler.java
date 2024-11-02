package com.acme.nutrimove.platform.subscriptions.interfaces.rest.transform;

import com.acme.nutrimove.platform.subscriptions.domain.model.commands.CreateSubscriptionCommand;
import com.acme.nutrimove.platform.subscriptions.interfaces.rest.resources.CreateSubscriptionResource;

public class CreateSubscriptionCommandFromResourceAssembler {
    public static CreateSubscriptionCommand toCommand(CreateSubscriptionResource resource) {
        return new CreateSubscriptionCommand(resource.description(), resource.price(), resource.monthDuration(), resource.trial(), resource.userId());
    }
}