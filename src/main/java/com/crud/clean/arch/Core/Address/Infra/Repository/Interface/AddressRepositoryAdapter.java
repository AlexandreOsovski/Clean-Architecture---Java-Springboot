package com.crud.clean.arch.Core.Address.Infra.Repository.Interface;

import java.util.Optional;

import com.crud.clean.arch.Core.Address.Domain.AddressDomain;

public interface AddressRepositoryAdapter {
    AddressDomain save(AddressDomain address);

    Optional<AddressDomain> findByUserId(Long userId);

    Optional<AddressDomain> findById(Long id);

    // List<AddressDomain> findWhere(FilterAddressRequestDto dto);
}
