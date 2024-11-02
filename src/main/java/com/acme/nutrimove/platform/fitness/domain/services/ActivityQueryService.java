package com.acme.nutrimove.platform.fitness.domain.services;

import com.acme.nutrimove.platform.fitness.domain.model.aggregates.Activity;
import com.acme.nutrimove.platform.fitness.domain.model.commands.CreateActivityCommand;
import com.acme.nutrimove.platform.fitness.domain.model.queries.GetActivityByIdQuery;
import com.acme.nutrimove.platform.fitness.domain.model.queries.GetAllActivityByNameQuery;

import java.util.List;
import java.util.Optional;

public interface ActivityQueryService {
    List<Activity> handle(GetAllActivityByNameQuery query);
    List<Activity> getAllActivities();

    Optional<Activity> handle(GetActivityByIdQuery query);

}
