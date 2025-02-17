package com.estudo.project.domain.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record PlaceRequestDTO(
        @NotBlank(message = "name é um campo obrigatório")
        String name,
        @NotBlank(message = "state é um campo obrigatório")
        String state,
        @Max(10)
        @Min(0)
        int grade,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
