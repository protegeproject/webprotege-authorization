package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

import java.util.List;
import java.util.Objects;

@JsonTypeName(ResetProjectRoleDefinitionsRequest.CHANNEL)
public record ResetProjectRoleDefinitionsResponse(@JsonProperty("roleDefinitions") List<RoleDefinition> roleDefinitions) implements Response {

    public ResetProjectRoleDefinitionsResponse(@JsonProperty("roleDefinitions" ) List<RoleDefinition> roleDefinitions) {
        this.roleDefinitions = List.copyOf(Objects.requireNonNull(roleDefinitions));
    }
}
