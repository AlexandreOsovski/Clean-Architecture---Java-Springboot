package com.crud.clean.arch.Core.User.Domain.Props;

import java.time.OffsetDateTime;

public record UserDomainProps(
                Long id,
                String firstName,
                String lastName,
                String documentNumber,
                String email,
                String password,
                OffsetDateTime createdAt,
                OffsetDateTime updatedAt) {
}