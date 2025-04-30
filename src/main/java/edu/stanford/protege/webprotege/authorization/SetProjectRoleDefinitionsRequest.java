package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.*;

@JsonTypeName(SetProjectRoleDefinitionsRequest.CHANNEL)
public record SetProjectRoleDefinitionsRequest(@JsonProperty("projectId") ProjectId projectId,
                                               @JsonProperty("roleDefinitions") List<RoleDefinition> roleDefinitions) implements Request<SetProjectRoleDefinitionsResponse> {

    public static final String CHANNEL = "webprotege.authorization.SetProjectRoleDefinitions";

    public SetProjectRoleDefinitionsRequest {
        Objects.requireNonNull(projectId);
        roleDefinitions = List.copyOf(Objects.requireNonNull(roleDefinitions));
    }

    @JsonCreator
    public static SetProjectRoleDefinitionsRequest get(@Nonnull @JsonProperty("projectId") ProjectId projectId,
                                                       @Nonnull @JsonProperty("roleDefinitions") List<RoleDefinition> roleDefinitions) {
        return new SetProjectRoleDefinitionsRequest(projectId, roleDefinitions);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
} 