package com.acme.nutrimove.platform.fitness.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Activity extends AbstractAggregateRoot<Activity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Getter
    private String description;

    @Column(nullable = false)
    @Getter
    private Float price;

    @Column(nullable = false)
    @Getter
    private Integer monthDuration;

    @Column(nullable = false)
    @Getter
    private String trial;

    @Column(nullable = false)
    @Getter
    private String userId;

    protected Activity() {}
}
