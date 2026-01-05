package com.crud.clean.arch.Core.User.Application.Usecase;

import org.springframework.stereotype.Service;

import com.crud.clean.arch.Core.User.Application.DTO.Response.UserResponseDto;
import com.crud.clean.arch.Core.User.Application.Mapper.UserMapper;
import com.crud.clean.arch.Core.User.Infra.Repository.UserRepositoryAdapter;

@Service
public class GetUserByIdUsecase {

    private final UserRepositoryAdapter userRepository;

    public GetUserByIdUsecase(UserRepositoryAdapter userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto execute(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
    }
}
