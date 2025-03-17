package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Set;

public record RoleDefinition(@Nonnull @JsonProperty("roleId") RoleId roleId,
                             @Nonnull @JsonProperty("parentRoles") Set<RoleId> parentRoles,
                             @Nonnull @JsonProperty("roleCapabilities") Set<Capability> roleCapabilities,
                             @Nonnull @JsonProperty("description") String description) {

    @JsonCreator
    public static RoleDefinition get(@Nonnull @JsonProperty("roleId") RoleId roleId,
                                     @Nonnull @JsonProperty("parentRoles") Set<RoleId> parentRoles,
                                     @Nonnull @JsonProperty("roleCapabilities") Set<Capability> roleCapabilities,
                                     @Nonnull @JsonProperty("description") String description) {
        return new RoleDefinition(roleId, parentRoles, roleCapabilities, description);
    }

    public RoleDefinition(@Nonnull @JsonProperty("roleId") RoleId roleId,
                          @Nonnull @JsonProperty("parentRoles") Set<RoleId> parentRoles,
                          @Nonnull @JsonProperty("roleCapabilities") Set<Capability> roleCapabilities,
                          @Nonnull @JsonProperty("description") String description) {
        this.roleId = Objects.requireNonNull(roleId);
        this.parentRoles = Set.copyOf(Objects.requireNonNull(parentRoles));
        this.roleCapabilities = Set.copyOf(Objects.requireNonNull(roleCapabilities));
        this.description = Objects.requireNonNull(description);
    }
}
