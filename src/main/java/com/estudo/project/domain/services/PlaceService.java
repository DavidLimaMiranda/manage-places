package com.estudo.project.domain.services;

import com.estudo.project.domain.dtos.PlaceRequestDTO;
import com.estudo.project.domain.entities.Place;
import com.estudo.project.domain.repositories.PlaceRepository;
import com.estudo.project.exceptions.DuplicatePlaceException;
import com.estudo.project.exceptions.PlaceNotFoundException;
import com.github.slugify.Slugify;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaceService {
    private PlaceRepository placeRepository;

    private Slugify slugify;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slugify = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequestDTO placeRequestDTO) {

        return placeRepository.findByName(placeRequestDTO.name())
                .hasElements()
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new DuplicatePlaceException
                                ("Você já registrou este lugar com o nome: " + placeRequestDTO.name()));
                    } else {
                        var place = new Place(
                                placeRequestDTO.name(), slugify.slugify(placeRequestDTO.name()),
                                placeRequestDTO.state(), placeRequestDTO.grade());

                        return placeRepository.save(place);
                    }
                });
    }

    public Flux<Place> findAllPlaces() {
        return placeRepository.findAll();
    }

    public Mono<Void> deletePlaceById(Long id) {
        return placeRepository.findById(id)
                .flatMap(place -> placeRepository.delete(place))
                .doOnError(throwable -> {
                    throw new PlaceNotFoundException("O lugar não foi encontrado");
                });
    }
}
