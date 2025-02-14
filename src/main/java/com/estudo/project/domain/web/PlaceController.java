package com.estudo.project.domain.web;

import com.estudo.project.domain.dtos.PlaceRequestDTO;
import com.estudo.project.domain.dtos.PlaceResponseDTO;
import com.estudo.project.domain.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
