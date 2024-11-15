package com.acme.nutrimove.platform.backend.Hydration.interfaces.rest.transform;

import com.acme.nutrimove.platform.backend.Hydration.domain.model.commands.CreateHydrationCommand;
import com.acme.nutrimove.platform.backend.Hydration.interfaces.rest.resources.CreateHydrationResource;

public class CreateHydrationCommnadFromResourceAssembler {

    public static CreateHydrationCommand toCommand(CreateHydrationResource resource) {
        return new CreateHydrationCommand(resource.date(), resource.quantity_ml(), resource.userId());
    }
}
