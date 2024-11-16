package com.acme.nutrimove.platform.backend.medicalhistory.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "medical_history")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Setter
    @Column(nullable = false)
    private LocalDate date;

    @Setter
    @Column(name = "medical_condition", nullable = false)
    private String medicalCondition;

    @Setter
    @Column(nullable = false)
    private String description;

    public MedicalHistory() {}

    public MedicalHistory(Long userId, LocalDate date, String medicalCondition, String description) {
        this.userId = userId;
        this.date = date;
        this.medicalCondition = medicalCondition;
        this.description = description;
    }

}
