package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.*;

@JsonTypeName(SetProjectRoleDefinitionsRequest.CHANNEL)
public record SetProjectRoleDefinitionsResponse(List<RoleDefinition> roleDefinitions) implements Response {

    public SetProjectRoleDefinitionsResponse {
        roleDefinitions = List.copyOf(Objects.requireNonNull(roleDefinitions));
    }

    @JsonCreator
    public static SetProjectRoleDefinitionsResponse get(@Nonnull @JsonProperty("roleDefinitions") List<RoleDefinition> roleDefinitions) {
        return new SetProjectRoleDefinitionsResponse(roleDefinitions);
    }
} 