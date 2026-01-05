package com.crud.clean.arch.Core.User.Application.Usecase;

import org.springframework.stereotype.Service;

import com.crud.clean.arch.Core.User.Infra.Repository.Interface.UserRepositoryAdapterInterface;
import com.crud.clean.arch.Shared.Domain.DomainValidationException;

@Service
public class DeleteUserUsecase {

    private final UserRepositoryAdapterInterface repository;

    public DeleteUserUsecase(UserRepositoryAdapterInterface repository) {
        this.repository = repository;
    }

    public void execute(Long userId) {
        if (userId == null || userId <= 0) {
            throw new DomainValidationException("id is required.");
        }

        repository.findById(userId)
                .orElseThrow(() -> new DomainValidationException("User not found."));

        repository.deleteById(userId);
    }
}
