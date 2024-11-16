package com.acme.nutrimove.platform.backend.Hydration.application.internal.commnandServices;

import com.acme.nutrimove.platform.backend.Hydration.domain.model.aggregates.Hydration;
import com.acme.nutrimove.platform.backend.Hydration.domain.model.commands.CreateHydrationCommand;
import com.acme.nutrimove.platform.backend.Hydration.domain.model.commands.DeleteHydrationCommand;
import com.acme.nutrimove.platform.backend.Hydration.domain.model.commands.UpdateHydrationCommand;
import com.acme.nutrimove.platform.backend.Hydration.domain.service.HydrationCommandService;
import com.acme.nutrimove.platform.backend.Hydration.infrastructure.persistance.jpa.HydrationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class hydrationCommandServiceImpl implements HydrationCommandService {

    private final HydrationRepository hydrationRepository;

    public hydrationCommandServiceImpl(HydrationRepository hydrationRepository) {
        this.hydrationRepository = hydrationRepository;
    }

    @Override
    public Optional<Hydration> handle(CreateHydrationCommand command) {
        var hydration = new Hydration(command);
        var createHydration = this.hydrationRepository.save(hydration);
        return Optional.of(createHydration);
    }

    @Override
    public Optional<Hydration> handle(UpdateHydrationCommand command) {
        var hydration =hydrationRepository.findById(command.id());
        if(hydration.isPresent()){
            hydration.get().setDate(command.date());
            hydration.get().setQuantity_ml(command.quantity_ml());
            var updateHydration = this.hydrationRepository.save(hydration.get());
            return Optional.of(updateHydration);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public void handle(DeleteHydrationCommand command) {
        this.hydrationRepository.deleteById(command.id());
    }
}
