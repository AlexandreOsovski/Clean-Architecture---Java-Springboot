package com.crud.clean.arch.Core.Address.Application.DTO.Response;

import java.time.OffsetDateTime;

public record AddressResponseDto(
        Long id,
        Long userId,
        String street,
        String neighborhood,
        String city,
        String state,
        String zipCode,
        String number,
        String complement,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt) {

}
