package com.estudo.project.domain.services;

import com.estudo.project.domain.dtos.PlaceRequestDTO;
import com.estudo.project.domain.entities.Place;
import com.estudo.project.domain.repositories.PlaceRepository;
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
        var place = new Place(
                placeRequestDTO.name(), slugify.slugify(placeRequestDTO.name()),
                placeRequestDTO.state());

        return placeRepository.save(place);
    }

    public Flux<Place> findAllPlaces() {
        return placeRepository.findAll();
    }

    public Mono<Void> deletePlaceById(Long id) {
       return placeRepository.findById(id).switchIfEmpty(Mono.error(new RuntimeException("Place não encontrada")))
                .flatMap(place -> placeRepository.delete(place))
                .doOnError(throwable -> {throw new RuntimeException("Error em deletar o place");});
    }
}
