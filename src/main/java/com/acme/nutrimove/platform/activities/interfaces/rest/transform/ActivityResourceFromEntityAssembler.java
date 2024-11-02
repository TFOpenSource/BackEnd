package com.acme.nutrimove.platform.activities.interfaces.rest.transform;

import com.acme.nutrimove.platform.activities.domain.model.aggregates.Activity;
import com.acme.nutrimove.platform.activities.interfaces.rest.resources.ActivityResource;

public class ActivityResourceFromEntityAssembler {

    public static ActivityResource toResourceFromEntity(Activity activity) {
        return new ActivityResource(activity.getId(), activity.getName(), activity.getDescription(), activity.getDuration(), activity.getUserId());
    }
}
