package com.estudo.project.domain.dtos;

import java.time.LocalDateTime;

public record PlaceRequestDTO(
        String name,
        String state,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
