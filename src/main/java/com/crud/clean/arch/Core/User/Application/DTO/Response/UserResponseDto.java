package com.crud.clean.arch.Core.User.Application.DTO.Response;

import java.time.OffsetDateTime;

public record UserResponseDto(
        Long id,
        String first_name,
        String last_name,
        String document_number,
        String email,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt) {
}
