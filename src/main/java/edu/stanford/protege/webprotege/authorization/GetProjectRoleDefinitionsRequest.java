package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonTypeName(GetProjectRoleDefinitionsRequest.CHANNEL)
public record GetProjectRoleDefinitionsRequest(ProjectId projectId) implements Request<GetProjectRoleDefinitionsResponse> {

    public static final String CHANNEL = "webprotege.authorization.GetProjectRoleDefinitions";

    @JsonCreator
    public static GetProjectRoleDefinitionsRequest get(@JsonProperty("projectId") ProjectId projectId) {
        return new GetProjectRoleDefinitionsRequest(Objects.requireNonNull(projectId));
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
