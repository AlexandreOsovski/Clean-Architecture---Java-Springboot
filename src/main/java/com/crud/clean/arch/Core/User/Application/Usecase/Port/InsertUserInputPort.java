package com.crud.clean.arch.Core.User.Application.Usecase.Port;

import com.crud.clean.arch.Core.User.Application.DTO.Request.InsertUserRequestDto;
import com.crud.clean.arch.Core.User.Application.DTO.Response.UserResponseDto;

public interface InsertUserInputPort {
    UserResponseDto execute(InsertUserRequestDto dto);
}