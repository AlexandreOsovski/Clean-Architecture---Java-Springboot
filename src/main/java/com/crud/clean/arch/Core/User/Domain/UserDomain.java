package com.crud.clean.arch.Core.User.Domain;

import com.crud.clean.arch.Core.User.Domain.Props.UserDomainProps;
import com.crud.clean.arch.Shared.Domain.DomainValidationException;

import java.time.OffsetDateTime;

public class UserDomain {

    private Long id;
    private String firstName;
    private String lastName;
    private String documentNumber;
    private String email;
    private String password;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public UserDomain(UserDomainProps props) {
        validate(props);

        this.id = props.id();
        this.firstName = props.firstName();
        this.lastName = props.lastName();
        this.documentNumber = props.documentNumber();
        this.email = props.email();
        this.password = props.password();
        this.createdAt = props.createdAt();
        this.updatedAt = props.updatedAt();
    }

    public UserDomain insert() {
        var now = OffsetDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        return this;
    }

    public UserDomain update(UserDomainProps props) {

        if (props.firstName() != null)
            this.firstName = props.firstName();

        if (props.lastName() != null)
            this.lastName = props.lastName();

        if (props.documentNumber() != null)
            this.documentNumber = props.documentNumber();

        if (props.email() != null)
            this.email = props.email();

        if (props.password() != null)
            this.password = props.password();

        this.updatedAt = OffsetDateTime.now();
        return this;
    }

    private void validate(UserDomainProps props) {

        if (props.firstName() == null || props.firstName().isBlank()
                || props.firstName().toLowerCase().equals("string")) {
            throw new DomainValidationException("First Name is required");
        }

        if (props.email() == null || props.email().isBlank() || props.email().toLowerCase().equals("string")) {
            throw new DomainValidationException("Email is required");
        }

        if (props.lastName() == null || props.lastName().isBlank() || props.lastName().toLowerCase().equals("string")) {
            throw new DomainValidationException("Last Name is required");
        }

        if (props.documentNumber() == null || props.documentNumber().isBlank()
                || props.documentNumber().toLowerCase().equals("string")) {
            throw new DomainValidationException("Document Number is required");
        }

        if (props.password() == null || props.password().isBlank()) {
            throw new DomainValidationException("Password required");
        }
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocumentNumber() {
        return documentNumber;
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
