package com.acme.nutrimove.platform.fitness.interfaces.rest;

import com.acme.nutrimove.platform.fitness.domain.model.aggregates.Activity;
import com.acme.nutrimove.platform.fitness.domain.model.queries.GetActivityByIdQuery;
import com.acme.nutrimove.platform.fitness.domain.model.queries.GetAllActivityByNameQuery;
import com.acme.nutrimove.platform.fitness.domain.services.ActivityCommandService;
import com.acme.nutrimove.platform.fitness.domain.services.ActivityQueryService;
import com.acme.nutrimove.platform.fitness.interfaces.rest.resources.ActivityResource;
import com.acme.nutrimove.platform.fitness.interfaces.rest.resources.CreateActivityResource;
import com.acme.nutrimove.platform.fitness.interfaces.rest.transform.ActivityResourceFromEntityAssembler;
import com.acme.nutrimove.platform.fitness.interfaces.rest.transform.CreateActivityCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/activities", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Activities", description = "Operation related to Activities")
public class ActivityController {
    private final ActivityQueryService activityQueryService;
    private final ActivityCommandService activityCommandService;

    public ActivityController(ActivityQueryService activityQueryService, ActivityCommandService activityCommandService) {
        this.activityQueryService = activityQueryService;
        this.activityCommandService = activityCommandService;
    }

    @Operation(summary = "Create an activity", description = "Create an activity source with the provided news API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Activity created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })

    @PostMapping
    public ResponseEntity<ActivityResource> createActivity(@RequestBody CreateActivityResource resource) {
        Optional<Activity> activity = activityCommandService
                .handle(CreateActivityCommandFromResourceAssembler.toCommand(resource));
        return activity.map(source -> new ResponseEntity<>(ActivityResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    private ResponseEntity<List<ActivityResource>> getAllActivityByName(String name) {
        var getAllActivityByNameQuery = new GetAllActivityByNameQuery(name);
        var activities = activityQueryService.handle(getAllActivityByNameQuery);
        if (activities.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var activityResources = activities.stream()
                .map(ActivityResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(activityResources);
    }

    @GetMapping("{id}")
    public ResponseEntity<ActivityResource> getFavoriteSourceById(@PathVariable Long id) {
        Optional<Activity> activity = activityQueryService.handle(new GetActivityByIdQuery(id));
        return activity.map(source -> ResponseEntity.ok(ActivityResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public ResponseEntity<List<ActivityResource>> getAllActivities() {
        var activities = activityQueryService.getAllActivities();
        if (activities.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var activityResources = activities.stream()
                .map(ActivityResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(activityResources);
    }

}
