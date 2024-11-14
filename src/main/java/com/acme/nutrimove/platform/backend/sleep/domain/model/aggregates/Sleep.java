package com.acme.nutrimove.platform.backend.sleep.domain.model.aggregates;

import com.acme.nutrimove.platform.backend.sleep.domain.model.commands.CreateSleepCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Entity
public class Sleep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private Long userId;

    @Setter
    @Column(nullable = false)
    private LocalDateTime date;

    @Setter
    @Column(nullable = false)
    private int hoursSlept;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Quality quality;

    public enum Quality {
        GOOD, BAD
    }

    public Sleep(CreateSleepCommand command) {
        this.userId = command.userId();
        this.date = command.date();
        this.hoursSlept = command.hoursSlept();
        this.quality = command.quality();
    }

    public Sleep() {}
}
