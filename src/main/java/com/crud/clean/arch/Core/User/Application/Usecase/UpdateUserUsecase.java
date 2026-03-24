package com.crud.clean.arch.Core.User.Application.Usecase;

import org.springframework.stereotype.Service;

import com.crud.clean.arch.Core.User.Application.DTO.Request.UpdateUserRequestDto;
import com.crud.clean.arch.Core.User.Application.DTO.Response.UserResponseDto;
import com.crud.clean.arch.Core.User.Application.Mapper.UserMapper;
import com.crud.clean.arch.Core.User.Domain.UserDomain;
import com.crud.clean.arch.Core.User.Domain.Props.UserDomainProps;
import com.crud.clean.arch.Core.User.Infra.Repository.Interface.UserRepositoryAdapterInterface;

@Service
public class UpdateUserUsecase {

    private final UserRepositoryAdapterInterface userRepository;

    public UpdateUserUsecase(UserRepositoryAdapterInterface userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto execute(Long id, UpdateUserRequestDto dto) {

        UserDomain user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        UserDomainProps props = new UserDomainProps(
                id,
                dto.first_name(),
                dto.last_name(),
                dto.document_number(),
                dto.email(),
                dto.password(),
                null,
                null);

        user.update(props);

        UserDomain updated = userRepository.save(user);
        return UserMapper.toResponse(updated);
    }
}