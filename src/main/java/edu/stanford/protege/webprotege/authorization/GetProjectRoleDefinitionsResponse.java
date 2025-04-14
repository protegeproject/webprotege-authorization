package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Response;

import java.util.List;
import java.util.Objects;

@JsonTypeName(GetProjectRoleDefinitionsRequest.CHANNEL)
public record GetProjectRoleDefinitionsResponse(ProjectId projectId, List<RoleDefinition> roleDefinitions) implements Response {

    public GetProjectRoleDefinitionsResponse(ProjectId projectId, List<RoleDefinition> roleDefinitions) {
        this.projectId = Objects.requireNonNull(projectId);
        this.roleDefinitions = List.copyOf(Objects.requireNonNull(roleDefinitions));
    }

    @JsonCreator
    public static GetProjectRoleDefinitionsResponse get(@JsonProperty("projectId") ProjectId projectId,
                                                        @JsonProperty("roleDefinitions") List<RoleDefinition> roleDefinitions) {
        return new GetProjectRoleDefinitionsResponse(
                Objects.requireNonNull(projectId),
                Objects.requireNonNull(roleDefinitions));
    }
}
