package com.crud.clean.arch.Core.Address.Infra.Repository.Interface;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.clean.arch.Core.Address.Infra.Model.AddressModel;

public interface AddressJpaRepository extends JpaRepository<AddressModel, Long> {
    Optional<AddressModel> findByUserId(Long userId);
}
