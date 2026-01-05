package com.crud.clean.arch.Core.Address.Domain;

import java.time.OffsetDateTime;

import com.crud.clean.arch.Core.Address.Domain.Props.AddressDomainProps;
import com.crud.clean.arch.Shared.Domain.DomainValidationException;

public class AddressDomain {
    private Long _id;
    private Long _userId;
    private String _street;
    private String _neighborhood;
    private String _city;
    private String _state;
    private String _zipCode;
    private String _number;
    private String _complement;
    private OffsetDateTime _createdAt;
    private OffsetDateTime _updatedAt;

    public AddressDomain(AddressDomainProps props) {
        validate(props);

        this._id = props.id();
        this._userId = props.userId();
        this._street = props.street();
        this._neighborhood = props.neighborhood();
        this._city = props.city();
        this._state = props.state();
        this._zipCode = props.zipCode();
        this._number = props.number();
        this._complement = props.complement();
        this._createdAt = props.createdAt();
        this._updatedAt = props.updatedAt();
    }

    public AddressDomain insert() {
        var now = OffsetDateTime.now();
        this._createdAt = now;
        this._updatedAt = now;
        return this;
    }

    public AddressDomain update(AddressDomainProps props) {

        if (props.street() != null && !props.street().isBlank()) {
            this._street = props.street();
        }

        if (props.neighborhood() != null && !props.neighborhood().isBlank()) {
            this._neighborhood = props.neighborhood();
        }

        if (props.city() != null && !props.city().isBlank()) {
            this._city = props.city();
        }

        if (props.state() != null && !props.state().isBlank()) {
            this._state = props.state();
        }

        if (props.zipCode() != null && !props.zipCode().isBlank()) {
            this._zipCode = props.zipCode();
        }

        if (props.number() != null && !props.number().isBlank()) {
            this._number = props.number();
        }

        if (props.complement() != null && !props.complement().isBlank()) {
            this._complement = props.complement();
        }

        this._updatedAt = OffsetDateTime.now();
        return this;
    }

    private void validate(AddressDomainProps props) {
        if (props.userId() == null || props.userId() == 0) {
            throw new DomainValidationException("user_id is required.");
        }

        if (props.street() == null || props.street().toLowerCase().equals("string") || props.street().isBlank()) {
            throw new DomainValidationException("street is required.");
        }

        if (props.neighborhood() == null || props.neighborhood().toLowerCase().equals("string")
                || props.neighborhood().isBlank()) {
            throw new DomainValidationException("neighborhood is required.");
        }
        if (props.city() == null || props.city().toLowerCase().equals("string") || props.city().isBlank()) {
            throw new DomainValidationException("city is required.");
        }

        if (props.state() == null || props.state().toLowerCase().equals("string") || props.state().isBlank()) {
            throw new DomainValidationException("state is required.");
        }
        if (props.zipCode() == null || props.zipCode().toLowerCase().equals("string") || props.zipCode().isBlank()) {
            throw new DomainValidationException("zip_code is required.");
        }
        if (props.number() == null || props.number().toLowerCase().equals("string") || props.number().isBlank()) {
            throw new DomainValidationException("number is required.");
        }

        if (props.complement() == null || props.complement().toLowerCase().equals("string")
                || props.complement().isBlank()) {
            throw new DomainValidationException("complement is required.");
        }
    }

    public Long getId() {
        return this._id;
    }

    public Long getUserId() {
        return this._userId;
    }

    public String getStreet() {
        return this._street;
    }

    public String getNeighborhood() {
        return this._neighborhood;
    }

    public String getCity() {
        return this._city;
    }

    public String getState() {
        return this._state;
    }

    public String getZipCode() {
        return this._zipCode;
    }

    public String getNumber() {
        return this._number;
    }

    public String getComplement() {
        return this._complement;
    }

    public OffsetDateTime getCreatedAt() {
        return _createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return _updatedAt;
    }
}
