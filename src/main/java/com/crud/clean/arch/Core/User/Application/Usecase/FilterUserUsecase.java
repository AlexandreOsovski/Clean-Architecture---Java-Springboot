package com.crud.clean.arch.Core.User.Application.Usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.clean.arch.Core.User.Application.DTO.Request.FilterUserRequestDto;
import com.crud.clean.arch.Core.User.Application.DTO.Response.UserResponseDto;
import com.crud.clean.arch.Core.User.Application.Mapper.UserMapper;
import com.crud.clean.arch.Core.User.Infra.Repository.Interface.UserRepositoryAdapterInterface;

@Service
public class FilterUserUsecase {

    private final UserRepositoryAdapterInterface userRepository;

    public FilterUserUsecase(UserRepositoryAdapterInterface userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> execute(FilterUserRequestDto dto) {
        return userRepository.findWhere(dto)
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}