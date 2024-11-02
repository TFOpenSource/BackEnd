package com.acme.nutrimove.platform.activities.interfaces.rest.transform;

import com.acme.nutrimove.platform.activities.domain.model.commands.CreateActivityCommand;
import com.acme.nutrimove.platform.activities.interfaces.rest.resources.CreateActivityResource;

public class CreateActivityCommandFromResourceAssembler {

    public static CreateActivityCommand toCommand(CreateActivityResource resource) {
        return new CreateActivityCommand(resource.name(), resource.description(), resource.duration(), resource.userId());
    }
}
