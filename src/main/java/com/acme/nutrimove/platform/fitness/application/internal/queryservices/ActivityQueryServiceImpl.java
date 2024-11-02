package com.acme.nutrimove.platform.fitness.application.internal.queryservices;

import com.acme.nutrimove.platform.fitness.domain.model.aggregates.Activity;
import com.acme.nutrimove.platform.fitness.domain.model.queries.GetActivityByIdQuery;
import com.acme.nutrimove.platform.fitness.domain.model.queries.GetAllActivityByNameQuery;
import com.acme.nutrimove.platform.fitness.domain.services.ActivityQueryService;
import com.acme.nutrimove.platform.fitness.infrastructure.persistence.jpa.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityQueryServiceImpl implements ActivityQueryService {
    private final ActivityRepository activityRepository;

    public ActivityQueryServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public List<Activity> handle(GetAllActivityByNameQuery query) {
        return activityRepository.findAllByName(query.name());
    }

    @Override
    public Optional<Activity> handle(GetActivityByIdQuery query) {
        return this.activityRepository.findById(query.id());
    }
}
