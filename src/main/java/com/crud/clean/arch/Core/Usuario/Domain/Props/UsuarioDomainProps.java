package com.crud.clean.arch.Core.Usuario.Domain.Props;

import java.time.OffsetDateTime;

public record UsuarioDomainProps(
        Long id,
        String nome,
        String email,
        String password,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt) {
}