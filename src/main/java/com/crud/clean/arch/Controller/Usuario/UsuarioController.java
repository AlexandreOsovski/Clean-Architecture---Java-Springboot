package com.crud.clean.arch.Controller.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.clean.arch.Core.User.Application.DTO.Request.InsertUserRequestDto;
import com.crud.clean.arch.Core.User.Application.DTO.Response.UserResponseDto;
import com.crud.clean.arch.Core.User.Application.Usecase.InsertUserUsecase;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Endpoints relacionados ao gerenciamento de usuários")
public class UsuarioController {

    private final InsertUserUsecase insertUserUsecase;

    public UsuarioController(InsertUserUsecase insertUserUsecase) {
        this.insertUserUsecase = insertUserUsecase;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> inserir(
            @Validated @RequestBody InsertUserRequestDto dto) {
        return ResponseEntity.ok(insertUserUsecase.execute(dto));
    }
}
