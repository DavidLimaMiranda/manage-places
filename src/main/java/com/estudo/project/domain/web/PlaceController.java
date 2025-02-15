package com.estudo.project.domain.web;

import com.estudo.project.domain.dtos.PlaceRequestDTO;
import com.estudo.project.domain.dtos.PlaceResponseDTO;
import com.estudo.project.domain.entities.Place;
import com.estudo.project.domain.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @PostMapping
    public ResponseEntity<Mono<PlaceResponseDTO>> create(@RequestBody PlaceRequestDTO place) {
        var responsePlace = placeService.create(place).map(PlaceMapper::PlaceToResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(responsePlace);
    }

    @GetMapping
    public ResponseEntity<Flux<Place>> findAllPlaces() {

        var places = placeService.findAllPlaces();

        return ResponseEntity.status(HttpStatus.OK).body(places);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePlaceById(@PathVariable Long id) {
        return placeService.deletePlaceById(id);
    }
}
