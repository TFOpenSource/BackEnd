package com.acme.nutrimove.platform.fitness.application.internal.commandservices;

import com.acme.nutrimove.platform.fitness.domain.model.aggregates.Activity;
import com.acme.nutrimove.platform.fitness.domain.model.commands.CreateActivityCommand;
import com.acme.nutrimove.platform.fitness.domain.model.queries.GetAllActivityByNameQuery;
import com.acme.nutrimove.platform.fitness.domain.services.ActivityCommandService;
import com.acme.nutrimove.platform.fitness.infrastructure.persistence.jpa.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityCommandServiceImpl implements ActivityCommandService {

    private final ActivityRepository activityRepository;

    public ActivityCommandServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;

    }


    @Override
    public Optional<Activity> handle(CreateActivityCommand command) {
        if (activityRepository.existsByNameAndDescription(command.name(), command.description())) {
            throw new IllegalArgumentException("Favorite source with same source ID already exists for this news API key");
        }
        var activity = new Activity(command);
        var createActivity = this.activityRepository.save(activity);
        return Optional.of(createActivity);
    }
}
