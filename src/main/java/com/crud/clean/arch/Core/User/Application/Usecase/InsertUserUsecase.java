package com.crud.clean.arch.Core.User.Application.Usecase;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.clean.arch.Core.User.Application.DTO.Request.InsertUserRequestDto;
import com.crud.clean.arch.Core.User.Application.DTO.Response.UserResponseDto;
import com.crud.clean.arch.Core.User.Application.Mapper.UserMapper;
import com.crud.clean.arch.Core.User.Domain.UserDomain;
import com.crud.clean.arch.Core.User.Domain.Props.UserDomainProps;
import com.crud.clean.arch.Core.User.Infra.Repository.UserRepositoryAdapter;

@Service
public class InsertUserUsecase {

    private final UserRepositoryAdapter usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public InsertUserUsecase(UserRepositoryAdapter usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto execute(InsertUserRequestDto dto) {

        if (usuarioRepository.findByEmail(dto.email()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        if (usuarioRepository.findByDocumentNumber(dto.document_number()).isPresent()) {
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
        UserDomain salvo = usuarioRepository.save(usuario);

        return UserMapper.toResponse(salvo);
    }
}
