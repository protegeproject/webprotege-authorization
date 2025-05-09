package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

import java.util.Objects;

@JsonTypeName(GetProjectRoleAssignmentsRequest.CHANNEL)
public record GetProjectRoleAssignmentsResponse(@JsonProperty("assignments") ProjectRoleAssignments assignments) implements Response {

    @JsonCreator
    public GetProjectRoleAssignmentsResponse(@JsonProperty("assignments") ProjectRoleAssignments assignments) {
        this.assignments = Objects.requireNonNull(assignments);
    }
}
