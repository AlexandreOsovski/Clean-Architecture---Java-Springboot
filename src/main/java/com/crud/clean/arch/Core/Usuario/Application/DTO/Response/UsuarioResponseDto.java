package com.crud.clean.arch.Core.Usuario.Application.DTO.Response;

import java.time.OffsetDateTime;

public record UsuarioResponseDto(
        Long id,
        String nome,
        String email,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt) {
}
