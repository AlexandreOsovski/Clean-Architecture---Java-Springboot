package com.crud.clean.arch.Core.Usuario.Infra.Repository.Interface;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.clean.arch.Core.Usuario.Infra.Model.UsuarioModel;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByEmail(String email);
}
