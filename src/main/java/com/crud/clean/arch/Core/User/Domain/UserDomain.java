package com.crud.clean.arch.Core.User.Domain;

import com.crud.clean.arch.Core.User.Domain.Props.UserDomainProps;
import com.crud.clean.arch.Shared.Domain.DomainValidationException;

import java.time.OffsetDateTime;

public class UserDomain {

    private final Long _id;
    private String _firstName;
    private String _lastName;
    private String _documentNumber;
    private String _email;
    private String _password;
    private OffsetDateTime _createdAt;
    private OffsetDateTime _updatedAt;

    public UserDomain(UserDomainProps props) {
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
        validateForInsert();
        var now = OffsetDateTime.now();
        this._createdAt = now;
        this._updatedAt = now;
        return this;
    }

    public UserDomain update(UserDomainProps props) {
        validateForUpdate(props);

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

    private void validateForInsert() {
        if (isBlankOrPlaceholder(_firstName))
            throw new DomainValidationException("First Name is required");

        if (isBlankOrPlaceholder(_lastName))
            throw new DomainValidationException("Last Name is required");

        if (isBlankOrPlaceholder(_documentNumber))
            throw new DomainValidationException("Document Number is required");

        if (isBlankOrPlaceholder(_email))
            throw new DomainValidationException("Email is required");

        if (_password == null || _password.isBlank())
            throw new DomainValidationException("Password is required");
    }

    private void validateForUpdate(UserDomainProps props) {
        if (props.email() != null && isBlankOrPlaceholder(props.email()))
            throw new DomainValidationException("Invalid Email");

        if (props.firstName() != null && isBlankOrPlaceholder(props.firstName()))
            throw new DomainValidationException("Invalid First Name");

        if (props.lastName() != null && isBlankOrPlaceholder(props.lastName()))
            throw new DomainValidationException("Invalid Last Name");

        if (props.documentNumber() != null && isBlankOrPlaceholder(props.documentNumber()))
            throw new DomainValidationException("Invalid Document Number");
    }

    private boolean isBlankOrPlaceholder(String value) {
        return value == null || value.isBlank() || value.equalsIgnoreCase("string");
    }

    public Long getId() { return _id; }
    public String getFirstName() { return _firstName; }
    public String getLastName() { return _lastName; }
    public String getDocumentNumber() { return _documentNumber; }
    public String getEmail() { return _email; }
    public String getPassword() { return _password; }
    public OffsetDateTime getCreatedAt() { return _createdAt; }
    public OffsetDateTime getUpdatedAt() { return _updatedAt; }
}