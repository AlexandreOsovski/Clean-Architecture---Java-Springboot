package com.crud.clean.arch.Core.Address.Application.Mapper;

import com.crud.clean.arch.Core.Address.Application.DTO.Response.AddressResponseDto;
import com.crud.clean.arch.Core.Address.Domain.AddressDomain;
import com.crud.clean.arch.Core.Address.Domain.Props.AddressDomainProps;
import com.crud.clean.arch.Core.Address.Infra.Model.AddressModel;
import com.crud.clean.arch.Core.User.Infra.Model.UserModel;

public class AddressMapper {

    public static AddressDomain toDomain(AddressModel model) {
        AddressDomainProps props = new AddressDomainProps(
                model.getId(),
                model.getUser().getId(),
                model.getStreet(),
                model.getNeighborhood(),
                model.getCity(),
                model.getState(),
                model.getZipCode(),
                model.getNumber(),
                model.getComplement(),
                model.getCreatedAt(),
                model.getUpdatedAt());

        return new AddressDomain(props);
    }

    public static AddressModel toModel(AddressDomain domain) {
        AddressModel model = new AddressModel();
        model.setId(domain.getId());

        // 👇 cria referência da entidade (JPA way)
        UserModel user = new UserModel();
        user.setId(domain.getUserId());
        model.setUser(user);

        model.setStreet(domain.getStreet());
        model.setNeighborhood(domain.getNeighborhood());
        model.setCity(domain.getCity());
        model.setState(domain.getState());
        model.setZipCode(domain.getZipCode());
        model.setNumber(domain.getNumber());
        model.setComplement(domain.getComplement());
        model.setCreatedAt(domain.getCreatedAt());
        model.setUpdatedAt(domain.getUpdatedAt());
        return model;
    }

    public static AddressResponseDto toResponse(AddressDomain domain) {
        return new AddressResponseDto(
                domain.getId(),
                domain.getUserId(),
                domain.getStreet(),
                domain.getNeighborhood(),
                domain.getCity(),
                domain.getState(),
                domain.getZipCode(),
                domain.getNumber(),
                domain.getComplement(),
                domain.getCreatedAt(),
                domain.getUpdatedAt());
    }
}
