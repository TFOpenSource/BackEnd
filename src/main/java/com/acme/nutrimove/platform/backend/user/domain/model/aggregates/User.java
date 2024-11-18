package com.acme.nutrimove.platform.backend.user.domain.model.aggregates;

import com.acme.nutrimove.platform.backend.goal.domain.model.aggregates.Goal;
import com.acme.nutrimove.platform.backend.user.domain.model.commands.CreateUserCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableJpaAuditing
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @Column(nullable = false)
    private String lastname;

    @Setter
    @Column(nullable = false, unique = true)
    private String email;

    @Setter
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Privacy privacy;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Goal> goals;

    public enum Privacy {
        PRIVATE, PUBLIC
    }

    public User(CreateUserCommand command) {
        this.name = command.name();
        this.lastname = command.lastname();
        this.email = command.email();
        this.password = command.password();
        this.privacy = command.privacy();
        this.createdAt = LocalDateTime.now();
    }

    public User() {}
}
