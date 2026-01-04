package com.crud.clean.arch.Core.Usuario.Application.DTO.Request;

import jakarta.validation.constraints.Email;

public record BuscarUsuarioRequestDto(
        String nome,
        @Email(message = "Email inválido")
        String email
) {}
