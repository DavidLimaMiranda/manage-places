package com.estudo.project.domain.web;

import com.estudo.project.domain.dtos.PlaceResponseDTO;
import com.estudo.project.domain.entities.Place;

public class PlaceMapper {
    public static PlaceResponseDTO PlaceToResponse(Place place) {
        return new PlaceResponseDTO(place.name, place.slug, place.state, place.grade,
                                    place.createdAt, place.updatedAt);
    }
}
