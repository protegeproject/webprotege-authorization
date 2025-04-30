package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public record RoleDefinition(@Nonnull @JsonProperty("roleId") RoleId roleId,
                             @Nonnull @JsonProperty("roleType") RoleType roleType,
                             @Nonnull @JsonProperty("parentRoles") Set<RoleId> parentRoles,
                             @Nonnull @JsonProperty("roleCapabilities") Set<Capability> roleCapabilities,
                             @Nonnull @JsonProperty("label") String label,
                             @Nonnull @JsonProperty("description") String description) {

    public RoleDefinition(@Nonnull @JsonProperty("roleId") RoleId roleId,
                          @Nonnull @JsonProperty("roleType") RoleType roleType,
                          @Nonnull @JsonProperty("parentRoles") Set<RoleId> parentRoles,
                          @Nonnull @JsonProperty("roleCapabilities") Set<Capability> roleCapabilities,
                          @Nonnull @JsonProperty("label") String label,
                          @Nonnull @JsonProperty("description") String description) {
        this.roleId = Objects.requireNonNull(roleId);
        this.roleType = Objects.requireNonNull(roleType);
        this.parentRoles = Set.copyOf(Objects.requireNonNull(parentRoles));
        this.roleCapabilities = Set.copyOf(Objects.requireNonNull(roleCapabilities));
        this.label = Objects.requireNonNull(label);
        this.description = Objects.requireNonNull(description);
    }

    @JsonCreator
    public static RoleDefinition get(@JsonProperty("roleId") RoleId roleId,
                                     @JsonProperty("roleType") RoleType roleType,
                                     @JsonProperty("parentRoles") Set<RoleId> parentRoles,
                                     @JsonProperty("roleCapabilities") Set<Capability> roleCapabilities,
                                     @JsonProperty("label") String label,
                                     @JsonProperty("description") String description) {
        return new RoleDefinition(roleId, roleType, parentRoles, roleCapabilities,
                Objects.requireNonNullElse(label, ""),
                description);
    }


    public RoleDefinition withoutCapabilities(Predicate<Capability> filter) {
        var remainingCapabilities = roleCapabilities.stream().filter(not(filter)).collect(Collectors.toSet());
        return new RoleDefinition(roleId, roleType, parentRoles, remainingCapabilities, label, description);
    }

    public RoleDefinition addCapabilities(Collection<? extends Capability> capabilities) {
        var combinedCapabilities = new LinkedHashSet<>(this.roleCapabilities);
        combinedCapabilities.addAll(capabilities);
        return new RoleDefinition(roleId, roleType, parentRoles, combinedCapabilities, label, description);
    }
}
