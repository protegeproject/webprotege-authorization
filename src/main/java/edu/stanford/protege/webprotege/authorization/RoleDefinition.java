package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Set;

public record RoleDefinition(@Nonnull @JsonProperty("roleId") RoleId roleId,
                             @Nonnull @JsonProperty("roleType") RoleType roleType,
                             @Nonnull @JsonProperty("parentRoles") Set<RoleId> parentRoles,
                             @Nonnull @JsonProperty("roleCapabilities") Set<Capability> roleCapabilities,
                             @Nonnull @JsonProperty("description") String description) {

    public RoleDefinition(@Nonnull @JsonProperty("roleId") RoleId roleId,
                          @Nonnull @JsonProperty("roleType") RoleType roleType,
                          @Nonnull @JsonProperty("parentRoles") Set<RoleId> parentRoles,
                          @Nonnull @JsonProperty("roleCapabilities") Set<Capability> roleCapabilities,
                          @Nonnull @JsonProperty("description") String description) {
        this.roleId = Objects.requireNonNull(roleId);
        this.roleType = Objects.requireNonNull(roleType);
        this.parentRoles = Set.copyOf(Objects.requireNonNull(parentRoles));
        this.roleCapabilities = Set.copyOf(Objects.requireNonNull(roleCapabilities));
        this.description = Objects.requireNonNull(description);
    }

    @JsonCreator
    public static RoleDefinition get(@JsonProperty("roleId") RoleId roleId,
                                     @JsonProperty("roleType") RoleType roleType,
                                     @JsonProperty("parentRoles") Set<RoleId> parentRoles,
                                     @JsonProperty("roleCapabilities") Set<Capability> roleCapabilities,
                                     @JsonProperty("description") String description) {
        return new RoleDefinition(roleId, roleType, parentRoles, roleCapabilities, description);
    }
}
