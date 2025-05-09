package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;

@JsonTypeName(GetProjectRoleAssignmentsRequest.CHANNEL)
public record GetProjectRoleAssignmentsRequest(@JsonProperty("projectId") ProjectId projectId) implements ProjectRequest<GetProjectRoleAssignmentsResponse> {

    public static final String CHANNEL = "webprotege.authorization.GetProjectRoleAssignments";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
