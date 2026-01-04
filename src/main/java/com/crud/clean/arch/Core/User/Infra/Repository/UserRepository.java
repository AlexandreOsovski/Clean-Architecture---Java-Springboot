package com.crud.clean.arch.Core.User.Infra.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Repository;

import com.crud.clean.arch.Core.User.Application.DTO.Request.FilterUserRequestDto;
import com.crud.clean.arch.Core.User.Application.Mapper.UserMapper;
import com.crud.clean.arch.Core.User.Domain.UserDomain;
import com.crud.clean.arch.Core.User.Infra.Model.UserModel;
import com.crud.clean.arch.Core.User.Infra.Repository.Interface.UserJpaRepository;
import com.crud.clean.arch.Core.User.Infra.Repository.Interface.UserRepositoryAdapter;

@Repository
public class UserRepository implements UserRepositoryAdapter {

    private final UserJpaRepository jpa;

    public UserRepository(UserJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public UserDomain save(UserDomain usuario) {
        UserModel model = UserMapper.toModel(usuario);
        UserModel saved = jpa.save(model);
        return UserMapper.toDomain(saved);
    }

    @Override
    public Optional<UserDomain> findByEmail(String email) {
        return jpa.findByEmail(email).map(UserMapper::toDomain);
    }

    @Override
    public Optional<UserDomain> findByDocumentNumber(String documentNumber) {
        return jpa.findByDocumentNumber(documentNumber).map(UserMapper::toDomain);
    }

    @Override
    public Optional<UserDomain> findById(Long id) {
        return jpa.findById(id).map(UserMapper::toDomain);
    }

    @Override
    public List<UserDomain> findWhere(FilterUserRequestDto dto) {
        UserModel probe = new UserModel();

        if (dto.first_name() != null && !dto.first_name().isBlank()) {
            probe.setFirstName(dto.first_name());
        }

        if (dto.last_name() != null && !dto.last_name().isBlank()) {
            probe.setLastName(dto.last_name());
        }

        if (dto.document_number() != null && !dto.document_number().isBlank()) {
            probe.setDocumentNumber(dto.document_number());
        }

        if (dto.email() != null && !dto.email().isBlank()) {
            probe.setEmail(dto.email());
        }

        Example<UserModel> example = Example.of(probe, ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));

        return jpa.findAll(example)
                .stream()
                .map(UserMapper::toDomain)
                .toList();
    }

}
