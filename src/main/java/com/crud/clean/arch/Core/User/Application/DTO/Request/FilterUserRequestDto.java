package com.crud.clean.arch.Core.User.Application.DTO.Request;

public record FilterUserRequestDto(
                String first_name,
                String last_name,
                String document_number,
                String email) {
}
