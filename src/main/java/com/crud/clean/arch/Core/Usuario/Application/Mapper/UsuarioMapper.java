package com.crud.clean.arch.Core.Usuario.Application.Mapper;

import com.crud.clean.arch.Core.Usuario.Application.DTO.Response.UsuarioResponseDto;
import com.crud.clean.arch.Core.Usuario.Domain.UsuarioDomain;
import com.crud.clean.arch.Core.Usuario.Domain.Props.UsuarioDomainProps;
import com.crud.clean.arch.Core.Usuario.Infra.Model.UsuarioModel;

public class UsuarioMapper {

    public static UsuarioDomain toDomain(UsuarioModel model) {

        UsuarioDomainProps props = new UsuarioDomainProps(
                model.getId(),
                model.getNome(),
                model.getEmail(),
                model.getPassword(),
                model.getCreatedAt(),
                model.getUpdatedAt());

        return new UsuarioDomain(props);
    }

    public static UsuarioModel toModel(UsuarioDomain domain) {

        UsuarioModel model = new UsuarioModel();

        model.setId(domain.getId());
        model.setNome(domain.getNome());
        model.setEmail(domain.getEmail());
        model.setPassword(domain.getPassword());
        model.setCreatedAt(domain.getCreatedAt());
        model.setUpdatedAt(domain.getUpdatedAt());

        return model;
    }

    public static UsuarioResponseDto toResponse(UsuarioDomain domain) {
        return new UsuarioResponseDto(
                domain.getId(),
                domain.getNome(),
                domain.getEmail(),
                domain.getCreatedAt(),
                domain.getUpdatedAt());
    }
}
