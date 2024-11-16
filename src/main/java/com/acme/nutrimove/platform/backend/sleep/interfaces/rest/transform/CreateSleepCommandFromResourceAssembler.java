package com.acme.nutrimove.platform.backend.sleep.interfaces.rest.transform;

import com.acme.nutrimove.platform.backend.sleep.domain.model.commands.CreateSleepCommand;
import com.acme.nutrimove.platform.backend.sleep.interfaces.rest.resources.CreateSleepResource;
import com.acme.nutrimove.platform.backend.sleep.domain.model.aggregates.Sleep.Quality;

public class CreateSleepCommandFromResourceAssembler {

    public static CreateSleepCommand toCommand(CreateSleepResource resource) {
        return new CreateSleepCommand(
                resource.userId(),
                resource.date(),
                resource.hoursSlept(),
                Quality.valueOf(resource.quality().toUpperCase())
        );
    }
}
