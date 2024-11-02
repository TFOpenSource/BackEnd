package com.acme.nutrimove.platform.fitness.interfaces.rest.transform;

import com.acme.nutrimove.platform.fitness.domain.model.aggregates.Activity;
import com.acme.nutrimove.platform.fitness.interfaces.rest.resources.ActivityResource;

public class ActivityResourceFromEntityAssembler {

    public static ActivityResource toResourceFromEntity(Activity activity) {
        return new ActivityResource(activity.getId(), activity.getName(), activity.getDescription(), activity.getDuration(), activity.getUserId());
    }
}
