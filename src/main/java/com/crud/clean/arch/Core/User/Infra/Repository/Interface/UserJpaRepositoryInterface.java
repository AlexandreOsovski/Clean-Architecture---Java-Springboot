package com.crud.clean.arch.Core.User.Infra.Repository.Interface;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.clean.arch.Core.User.Infra.Model.UserModel;

public interface UserJpaRepositoryInterface extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);

    Optional<UserModel> findByDocumentNumber(String documentNumber);
}
