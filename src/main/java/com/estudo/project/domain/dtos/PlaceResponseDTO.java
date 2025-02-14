package com.estudo.project.domain.dtos;

import java.time.LocalDateTime;

public record PlaceResponseDTO(
        String name,
        String slug,
        String state,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
