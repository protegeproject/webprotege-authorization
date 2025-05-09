package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

import java.util.Objects;

@JsonTypeName(SetProjectRoleAssignmentsRequest.CHANNEL)
public record SetProjectRoleAssignmentsResponse(@JsonProperty("assignments") ProjectRoleAssignments assignments) implements Response {

    public SetProjectRoleAssignmentsResponse(@JsonProperty("assignments" ) ProjectRoleAssignments assignments) {
        this.assignments = Objects.requireNonNull(assignments);
    }
}
