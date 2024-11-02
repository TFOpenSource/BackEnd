package com.acme.nutrimove.platform.fitness.domain.model.aggregates;
import com.acme.nutrimove.platform.fitness.domain.model.commands.CreateActivityCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Activity {

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
    private String duration;

    @Column(nullable = false)
    @Getter
    private Long userId;

    public Activity(CreateActivityCommand command) {
        this.name = command.name();
        this.description = command.description();
        this.duration = command.duration();
        this.userId = command.user_id();

    }

    public Activity() {}
}
