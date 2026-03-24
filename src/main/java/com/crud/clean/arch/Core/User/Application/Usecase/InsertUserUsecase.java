package com.crud.clean.arch.Core.User.Application.Usecase;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.clean.arch.Core.User.Application.DTO.Request.InsertUserRequestDto;
import com.crud.clean.arch.Core.User.Application.DTO.Response.UserResponseDto;
import com.crud.clean.arch.Core.User.Application.Mapper.UserMapper;
import com.crud.clean.arch.Core.User.Application.Usecase.Port.InsertUserInputPort;
import com.crud.clean.arch.Core.User.Domain.UserDomain;
import com.crud.clean.arch.Core.User.Domain.Props.UserDomainProps;
import com.crud.clean.arch.Core.User.Infra.Repository.Interface.UserRepositoryAdapterInterface;

@Service
public class InsertUserUsecase implements InsertUserInputPort {

    private final UserRepositoryAdapterInterface userRepository;
    private final PasswordEncoder passwordEncoder;

    public InsertUserUsecase(UserRepositoryAdapterInterface userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDto execute(InsertUserRequestDto dto) {

        if (userRepository.findByEmail(dto.email()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        if (userRepository.findByDocumentNumber(dto.document_number()).isPresent()) {
            throw new IllegalArgumentException("Numero de documento já cadastrado");
        }

        UserDomainProps props = new UserDomainProps(
                null,
                dto.first_name(),
                dto.last_name(),
                dto.document_number(),
                dto.email(),
                passwordEncoder.encode(dto.password()),
                null,
                null);

        UserDomain usuario = new UserDomain(props).insert();
        UserDomain salvo = userRepository.save(usuario);

        return UserMapper.toResponse(salvo);
    }
}