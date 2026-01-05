package com.crud.clean.arch.Core.User.Domain;

import com.crud.clean.arch.Core.User.Domain.Props.UserDomainProps;
import com.crud.clean.arch.Shared.Domain.DomainValidationException;

import java.time.OffsetDateTime;

public class UserDomain {

    private Long _id;
    private String _firstName;
    private String _lastName;
    private String _documentNumber;
    private String _email;
    private String _password;
    private OffsetDateTime _createdAt;
    private OffsetDateTime _updatedAt;

    public UserDomain(UserDomainProps props) {
        validate(props);

        this._id = props.id();
        this._firstName = props.firstName();
        this._lastName = props.lastName();
        this._documentNumber = props.documentNumber();
        this._email = props.email();
        this._password = props.password();
        this._createdAt = props.createdAt();
        this._updatedAt = props.updatedAt();
    }

    public UserDomain insert() {
        var now = OffsetDateTime.now();
        this._createdAt = now;
        this._updatedAt = now;
        return this;
    }

    public UserDomain update(UserDomainProps props) {

        if (props.firstName() != null)
            this._firstName = props.firstName();

        if (props.lastName() != null)
            this._lastName = props.lastName();

        if (props.documentNumber() != null)
            this._documentNumber = props.documentNumber();

        if (props.email() != null)
            this._email = props.email();

        if (props.password() != null)
            this._password = props.password();

        this._updatedAt = OffsetDateTime.now();
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
        return _id;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getDocumentNumber() {
        return _documentNumber;
    }

    public String getEmail() {
        return _email;
    }

    public String getPassword() {
        return _password;
    }

    public OffsetDateTime getCreatedAt() {
        return _createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return _updatedAt;
    }
}
