package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;

import static edu.stanford.protege.webprotege.authorization.ResetProjectRoleDefinitionsRequest.CHANNEL;

@JsonTypeName(CHANNEL)
public record ResetProjectRoleDefinitionsRequest(@JsonProperty("projectId") ProjectId projectId) implements ProjectRequest<ResetProjectRoleDefinitionsResponse> {

    public static final String CHANNEL = "webprotege.authorization.ResetProjectRoleDefinitions";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
