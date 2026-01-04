package com.crud.clean.arch.Core.User.Application.Mapper;

import com.crud.clean.arch.Core.User.Application.DTO.Response.UserResponseDto;
import com.crud.clean.arch.Core.User.Domain.UserDomain;
import com.crud.clean.arch.Core.User.Domain.Props.UserDomainProps;
import com.crud.clean.arch.Core.User.Infra.Model.UserModel;

public class UserMapper {

    public static UserDomain toDomain(UserModel model) {

        UserDomainProps props = new UserDomainProps(
                model.getId(),
                model.getFirstName(),
                model.getLastName(),
                model.getDocumentNumber(),
                model.getEmail(),
                model.getPassword(),
                model.getCreatedAt(),
                model.getUpdatedAt());

        return new UserDomain(props);
    }

    public static UserModel toModel(UserDomain domain) {

        UserModel model = new UserModel();

        model.setId(domain.getId());
        model.setFirstName(domain.getFirstName());
        model.setLastName(domain.getLastName());
        model.setDocumentNumber(domain.getDocumentNumber());
        model.setEmail(domain.getEmail());
        model.setPassword(domain.getPassword());
        model.setCreatedAt(domain.getCreatedAt());
        model.setUpdatedAt(domain.getUpdatedAt());

        return model;
    }

    public static UserResponseDto toResponse(UserDomain domain) {
        return new UserResponseDto(
                domain.getId(),
                domain.getFirstName(),
                domain.getLastName(),
                domain.getDocumentNumber(),
                domain.getEmail(),
                domain.getCreatedAt(),
                domain.getUpdatedAt());
    }
}
