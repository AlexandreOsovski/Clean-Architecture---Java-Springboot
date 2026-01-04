package com.crud.clean.arch.Core.Usuario.Domain;

import com.crud.clean.arch.Core.Usuario.Domain.Props.UsuarioDomainProps;
import com.crud.clean.arch.Shared.Domain.DomainValidationException;

import java.time.OffsetDateTime;

public class UsuarioDomain {

    private Long id;
    private String nome;
    private String email;
    private String password;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public UsuarioDomain(UsuarioDomainProps props) {
        validate(props);

        this.id = props.id();
        this.nome = props.nome();
        this.email = props.email();
        this.password = props.password();
        this.createdAt = props.createdAt();
        this.updatedAt = props.updatedAt();
    }

    /*
     * =========================
     * Lifecycle
     * ==========================
     */

    public UsuarioDomain insert() {
        var now = OffsetDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        return this;
    }

    public UsuarioDomain update(UsuarioDomainProps props) {

        if (props.nome() != null)
            this.nome = props.nome();

        if (props.email() != null)
            this.email = props.email();

        if (props.password() != null)
            this.password = props.password();

        this.updatedAt = OffsetDateTime.now();
        return this;
    }

    private void validate(UsuarioDomainProps props) {

        if (props.nome() == null || props.nome().isBlank()) {
            throw new DomainValidationException("Nome é obrigatório.");
        }

        if (props.email() == null || props.email().isBlank()) {
            throw new DomainValidationException("Email é obrigatório.");
        }

        if (props.password() == null || props.password().isBlank()) {
            throw new DomainValidationException("Password é obrigatório.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
}
