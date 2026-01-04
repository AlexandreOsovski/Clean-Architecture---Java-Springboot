package com.crud.clean.arch.Core.User.Application.DTO.Response;

import java.time.OffsetDateTime;

public record UserResponseDto(
                Long id,
                String nome,
                String sobrenome,
                String numero_documento,
                String email,
                OffsetDateTime createdAt,
                OffsetDateTime updatedAt) {
}
