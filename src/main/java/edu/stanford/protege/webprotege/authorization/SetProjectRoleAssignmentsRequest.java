package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;

import java.util.Objects;

import static edu.stanford.protege.webprotege.authorization.SetProjectRoleAssignmentsRequest.CHANNEL;

@JsonTypeName(CHANNEL)
public record SetProjectRoleAssignmentsRequest(@JsonProperty("projectId") ProjectId projectId,
                                               @JsonProperty("assignments") ProjectRoleAssignments assignments) implements Request<SetProjectRoleAssignmentsResponse> {

    public static final String CHANNEL = "webprotege.authorization.SetProjectRoleAssignments";

    public SetProjectRoleAssignmentsRequest(@JsonProperty("projectId" ) ProjectId projectId, @JsonProperty("assignments" ) ProjectRoleAssignments assignments) {
        this.projectId = Objects.requireNonNull(projectId);
        this.assignments = Objects.requireNonNull(assignments);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
