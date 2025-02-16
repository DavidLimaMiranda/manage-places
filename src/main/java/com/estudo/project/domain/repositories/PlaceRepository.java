package com.estudo.project.domain.repositories;

import com.estudo.project.domain.entities.Place;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PlaceRepository extends ReactiveCrudRepository<Place, Long> {
    public Flux<Place> findByName(String name);
}
