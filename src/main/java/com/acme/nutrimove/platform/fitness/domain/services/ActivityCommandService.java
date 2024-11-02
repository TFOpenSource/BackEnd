package com.acme.nutrimove.platform.fitness.domain.services;

import com.acme.nutrimove.platform.fitness.domain.model.aggregates.Activity;
import com.acme.nutrimove.platform.fitness.domain.model.commands.CreateActivityCommand;

import java.util.Optional;

public interface ActivityCommandService {

    Optional<Activity> handle(CreateActivityCommand command);

}
