package com.crud.clean.arch.Controller.User;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.crud.clean.arch.Core.User.Application.DTO.Request.FilterUserRequestDto;
import com.crud.clean.arch.Core.User.Application.DTO.Request.InsertUserRequestDto;
import com.crud.clean.arch.Core.User.Application.DTO.Request.UpdateUserRequestDto;
import com.crud.clean.arch.Core.User.Application.DTO.Response.UserResponseDto;
import com.crud.clean.arch.Core.User.Application.Usecase.DeleteUserUsecase;
import com.crud.clean.arch.Core.User.Application.Usecase.FilterUserUsecase;
import com.crud.clean.arch.Core.User.Application.Usecase.GetUserByIdUsecase;
import com.crud.clean.arch.Core.User.Application.Usecase.InsertUserUsecase;
import com.crud.clean.arch.Core.User.Application.Usecase.UpdateUserUsecase;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Endpoints relacionados ao gerenciamento de usuários")
public class UserController {

    private final InsertUserUsecase insertUserUsecase;
    private final DeleteUserUsecase deleteUserUsecase;
    private final GetUserByIdUsecase getUserByIdUsecase;
    private final FilterUserUsecase filterUserUsecase;
    private final UpdateUserUsecase updateUserUsecase;

    public UserController(
            InsertUserUsecase insertUserUsecase,
            DeleteUserUsecase deleteUserUsecase,
            GetUserByIdUsecase getUserByIdUsecase,
            FilterUserUsecase filterUserUsecase,
            UpdateUserUsecase updateUserUsecase) {
        this.insertUserUsecase = insertUserUsecase;
        this.deleteUserUsecase = deleteUserUsecase;
        this.getUserByIdUsecase = getUserByIdUsecase;
        this.filterUserUsecase = filterUserUsecase;
        this.updateUserUsecase = updateUserUsecase;
    }

    @PostMapping("adicionar")
    public ResponseEntity<UserResponseDto> inserir(
            @Validated @RequestBody InsertUserRequestDto dto) {
        return ResponseEntity.ok(insertUserUsecase.execute(dto));
    }

    @GetMapping("/{id}/buscar")
    public ResponseEntity<UserResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(getUserByIdUsecase.execute(id));
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<UserResponseDto>> filtrar(
            @RequestParam(required = false) String first_name,
            @RequestParam(required = false) String last_name,
            @RequestParam(required = false) String email) {

        FilterUserRequestDto dto = new FilterUserRequestDto(
                first_name,
                last_name,
                null,
                email);

        return ResponseEntity.ok(filterUserUsecase.execute(dto));
    }

    @PutMapping("/{id}/alterar")
    public ResponseEntity<UserResponseDto> atualizar(
            @PathVariable Long id,
            @RequestBody UpdateUserRequestDto dto) {
        return ResponseEntity.ok(updateUserUsecase.execute(id, dto));
    }

    @DeleteMapping("/{id}/deletar")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteUserUsecase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
