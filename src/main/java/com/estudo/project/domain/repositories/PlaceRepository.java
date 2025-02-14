package com.estudo.project.domain.repositories;

import com.estudo.project.domain.entities.Place;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlaceRepository extends ReactiveCrudRepository<Place, Long> {

}
