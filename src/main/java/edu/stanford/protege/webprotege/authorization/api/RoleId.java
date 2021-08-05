package edu.stanford.protege.webprotege.authorization.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Nonnull;

import static java.util.Objects.requireNonNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
public record RoleId(@Nonnull String id) {

    public RoleId {
        requireNonNull(id);
    }

    @JsonCreator
    public static RoleId valueOf(String id) {
        return new RoleId(id);
    }

    @JsonValue
    @Override
    public String id() {
        return id;
    }
}
