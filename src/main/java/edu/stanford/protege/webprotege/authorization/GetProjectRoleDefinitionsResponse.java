package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

import java.util.List;
import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonTypeName(GetProjectRoleDefinitionsRequest.CHANNEL)
public record GetProjectRoleDefinitionsResponse(List<RoleDefinition> roleDefinitions) implements Response {

    @JsonCreator
    public static GetProjectRoleDefinitionsResponse get(@JsonProperty("roleDefinitions") List<RoleDefinition> roleDefinitions) {
        return new GetProjectRoleDefinitionsResponse(Objects.requireNonNull(roleDefinitions));
    }
}
