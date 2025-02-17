package com.estudo.project.domain.dtos;

import java.time.LocalDateTime;

public record PlaceResponseDTO(
        String name,
        String slug,
        String state,
        int grade,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
