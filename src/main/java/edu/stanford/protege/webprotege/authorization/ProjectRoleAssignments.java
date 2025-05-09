package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public record ProjectRoleAssignments(@JsonProperty("userAssignments") List<UserRoleAssignment> userAssignments) {

    @JsonCreator
    public ProjectRoleAssignments(@JsonProperty("userAssignments" ) List<UserRoleAssignment> userAssignments) {
        this.userAssignments = Objects.requireNonNull(userAssignments);
    }
}
