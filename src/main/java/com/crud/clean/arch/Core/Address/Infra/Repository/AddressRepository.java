package com.crud.clean.arch.Core.Address.Infra.Repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.crud.clean.arch.Core.Address.Application.Mapper.AddressMapper;
import com.crud.clean.arch.Core.Address.Domain.AddressDomain;
import com.crud.clean.arch.Core.Address.Infra.Model.AddressModel;
import com.crud.clean.arch.Core.Address.Infra.Repository.Interface.AddressJpaRepository;
import com.crud.clean.arch.Core.Address.Infra.Repository.Interface.AddressRepositoryAdapter;

@Repository
public class AddressRepository implements AddressRepositoryAdapter {

    private final AddressJpaRepository jpa;

    public AddressRepository(AddressJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public AddressDomain save(AddressDomain address) {
        AddressModel model = AddressMapper.toModel(address);
        AddressModel saved = jpa.save(model);

        return AddressMapper.toDomain(saved);
    }

    @Override
    public Optional<AddressDomain> findByUserId(Long userId) {
        return jpa.findByUserId(userId)
                .map(AddressMapper::toDomain);
    }

    @Override
    public Optional<AddressDomain> findById(Long id) {
        return jpa.findById(id).map(AddressMapper::toDomain);
    }

}
