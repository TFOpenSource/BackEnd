package com.acme.nutrimove.platform.backend.Hydration.domain.model.aggregates;


import com.acme.nutrimove.platform.backend.Hydration.domain.model.commands.CreateHydrationCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Hydration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private LocalDate date;

    @Column(nullable = false)
    @Getter
    @Setter
    private Integer quantity_ml;

    @Column(nullable = false)
    @Getter
    private Long userId;

    public Hydration() {}

    public Hydration(CreateHydrationCommand command) {
        this.date = command.date();
        this.quantity_ml = command.quantity_ml();
        this.userId = command.userId();
    }


}
