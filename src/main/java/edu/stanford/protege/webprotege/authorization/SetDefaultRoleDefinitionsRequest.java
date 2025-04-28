package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Request;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.*;

@JsonTypeInfo(use = Id.NAME)
@JsonTypeName(SetDefaultRoleDefinitionsRequest.CHANNEL)
public record SetDefaultRoleDefinitionsRequest(@JsonProperty("roleDefinitions") List<RoleDefinition> roleDefinitions) implements Request<SetDefaultRoleDefinitionsResponse> {

    public static final String CHANNEL = "webprotege.authorization.SetDefaultRoleDefinitions";

    public SetDefaultRoleDefinitionsRequest {
        roleDefinitions = List.copyOf(Objects.requireNonNull(roleDefinitions));
    }

    @JsonCreator
    public static SetDefaultRoleDefinitionsRequest get(@Nonnull @JsonProperty("roleDefinitions") List<RoleDefinition> roleDefinitions) {
        return new SetDefaultRoleDefinitionsRequest(roleDefinitions);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
} 