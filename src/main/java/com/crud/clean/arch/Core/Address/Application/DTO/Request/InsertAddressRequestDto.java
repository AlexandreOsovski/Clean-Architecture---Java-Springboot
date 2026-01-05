package com.crud.clean.arch.Core.Address.Application.DTO.Request;

public record InsertAddressRequestDto(
        Long userId,
        String street,
        String neighborhood,
        String city,
        String state,
        String zipCode,
        String number,
        String complement) {
}
