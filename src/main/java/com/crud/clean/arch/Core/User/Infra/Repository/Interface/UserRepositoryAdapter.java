package com.crud.clean.arch.Core.User.Infra.Repository.Interface;

import java.util.List;
import java.util.Optional;

import com.crud.clean.arch.Core.User.Application.DTO.Request.FilterUserRequestDto;
import com.crud.clean.arch.Core.User.Domain.UserDomain;

public interface UserRepositoryAdapter {

    UserDomain save(UserDomain usuario);

    Optional<UserDomain> findByEmail(String email);

    Optional<UserDomain> findById(Long id);

    Optional<UserDomain> findByDocumentNumber(String numeroDocumento);

    List<UserDomain> findWhere(FilterUserRequestDto dto);

}
