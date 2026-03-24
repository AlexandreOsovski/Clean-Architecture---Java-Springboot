package com.crud.clean.arch.Core.User.Application.Usecase.Port;

import java.util.List;

import com.crud.clean.arch.Core.User.Application.DTO.Request.FilterUserRequestDto;
import com.crud.clean.arch.Core.User.Application.DTO.Request.UpdateUserRequestDto;
import com.crud.clean.arch.Core.User.Application.DTO.Response.UserResponseDto;

interface GetUserByIdInputPort {
    UserResponseDto execute(Long id);
}

interface FilterUserInputPort {
    List<UserResponseDto> execute(FilterUserRequestDto dto);
}

interface UpdateUserInputPort {
    UserResponseDto execute(Long id, UpdateUserRequestDto dto);
}

interface DeleteUserInputPort {
    void execute(Long id);
}