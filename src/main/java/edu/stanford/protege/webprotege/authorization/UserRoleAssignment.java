package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.stanford.protege.webprotege.common.UserId;

import java.util.Objects;

public record UserRoleAssignment(@JsonProperty("userId") UserId userId,
                                 @JsonProperty("roleId") RoleId roleId) {

    @JsonCreator
    public UserRoleAssignment(@JsonProperty("userId" ) UserId userId, @JsonProperty("roleId" ) RoleId roleId) {
        this.userId = Objects.requireNonNull(userId);
        this.roleId = Objects.requireNonNull(roleId);
    }
}
