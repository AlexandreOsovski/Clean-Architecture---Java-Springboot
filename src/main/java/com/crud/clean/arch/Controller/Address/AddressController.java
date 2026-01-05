package com.crud.clean.arch.Controller.Address;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/endereco")
@Tag(name = "Endereços", description = "Endpoints relacionados ao gerenciamento de endereços dos usuários")

public class AddressController {

    // private final InsertUserUsecase insertUserUsecase;

    // public UserController(InsertUserUsecase insertUserUsecase) {
    // this.insertUserUsecase = insertUserUsecase;
    // }

    // @PostMapping
    // public ResponseEntity<UserResponseDto> inserir(
    // @Validated @RequestBody InsertUserRequestDto dto) {
    // return ResponseEntity.ok(insertUserUsecase.execute(dto));
    // }
}
