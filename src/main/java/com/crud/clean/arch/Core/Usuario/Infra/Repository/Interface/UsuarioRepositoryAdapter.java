package com.crud.clean.arch.Core.Usuario.Infra.Repository.Interface;

import java.util.List;
import java.util.Optional;

import com.crud.clean.arch.Core.Usuario.Application.DTO.Request.FiltrarUsuarioRequestDto;
import com.crud.clean.arch.Core.Usuario.Domain.UsuarioDomain;

public interface UsuarioRepositoryAdapter {

    UsuarioDomain save(UsuarioDomain usuario);

    Optional<UsuarioDomain> findByEmail(String email);

    Optional<UsuarioDomain> findById(Long id);

    List<UsuarioDomain> findWhere(FiltrarUsuarioRequestDto dto);

}
