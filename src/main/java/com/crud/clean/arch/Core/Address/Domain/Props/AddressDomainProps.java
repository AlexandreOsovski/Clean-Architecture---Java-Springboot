package com.crud.clean.arch.Core.Address.Domain.Props;

import java.time.OffsetDateTime;

public record AddressDomainProps(
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
