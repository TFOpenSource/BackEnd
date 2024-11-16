package com.acme.nutrimove.platform.backend.medicalhistory.interfaces.rest.transform;

import com.acme.nutrimove.platform.backend.medicalhistory.domain.model.aggregates.MedicalHistory;
import com.acme.nutrimove.platform.backend.medicalhistory.interfaces.rest.resources.MedicalHistoryResource;

public class MedicalHistoryResourceFromEntityAssembler {

    public static MedicalHistoryResource toResourceFromEntity(MedicalHistory entity) {
        return new MedicalHistoryResource(
                entity.getId(),
                entity.getUserId(),
                entity.getDate(),
                entity.getMedicalCondition(),
                entity.getDescription()
        );
    }
}
