package com.estudo.project.domain.services;

import com.estudo.project.domain.dtos.PlaceRequestDTO;
import com.estudo.project.domain.entities.Place;
import com.estudo.project.domain.repositories.PlaceRepository;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@EnableR2dbcAuditing
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    private Slugify slugify;

    public PlaceService() {
        this.slugify = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequestDTO placeRequestDTO) {
        var place = new Place(
                placeRequestDTO.name(), slugify.slugify(placeRequestDTO.name()), placeRequestDTO.state(),
                placeRequestDTO.createdAt(), placeRequestDTO.updatedAt());

        return placeRepository.save(place);
    }
}
