package com.crud.clean.arch.Core.Usuario.Infra.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Repository;

import com.crud.clean.arch.Core.Usuario.Domain.UsuarioDomain;
import com.crud.clean.arch.Core.Usuario.Application.DTO.Request.FiltrarUsuarioRequestDto;
import com.crud.clean.arch.Core.Usuario.Application.Mapper.UsuarioMapper;
import com.crud.clean.arch.Core.Usuario.Infra.Model.UsuarioModel;
import com.crud.clean.arch.Core.Usuario.Infra.Repository.Interface.UsuarioJpaRepository;
import com.crud.clean.arch.Core.Usuario.Infra.Repository.Interface.UsuarioRepositoryAdapter;

@Repository
public class UsuarioRepository implements UsuarioRepositoryAdapter {

    private final UsuarioJpaRepository jpa;

    public UsuarioRepository(UsuarioJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public UsuarioDomain save(UsuarioDomain usuario) {
        UsuarioModel model = UsuarioMapper.toModel(usuario);
        UsuarioModel saved = jpa.save(model);
        return UsuarioMapper.toDomain(saved);
    }

    @Override
    public Optional<UsuarioDomain> findByEmail(String email) {
        return jpa.findByEmail(email).map(UsuarioMapper::toDomain);
    }

    @Override
    public Optional<UsuarioDomain> findById(Long id) {
        return jpa.findById(id).map(UsuarioMapper::toDomain);
    }

    @Override
    public List<UsuarioDomain> findWhere(FiltrarUsuarioRequestDto dto) {
        UsuarioModel probe = new UsuarioModel();

        if (dto.nome() != null && !dto.nome().isBlank()) {
            probe.setNome(dto.nome());
        }
        if (dto.email() != null && !dto.email().isBlank()) {
            probe.setEmail(dto.email());
        }

        Example<UsuarioModel> example = Example.of(probe, ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));

        return jpa.findAll(example)
                .stream()
                .map(UsuarioMapper::toDomain)
                .toList();
    }

}
