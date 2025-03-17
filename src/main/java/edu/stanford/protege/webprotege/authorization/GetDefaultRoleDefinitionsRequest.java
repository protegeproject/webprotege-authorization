package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Request;

import javax.annotation.Nonnull;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.*;

@JsonTypeInfo(use = Id.NAME)
@JsonTypeName(GetDefaultRoleDefinitionsRequest.CHANNEL)
public record GetDefaultRoleDefinitionsRequest() implements Request<GetDefaultRoleDefinitionsResponse> {

    public static final String CHANNEL = "webprotege.authorization.GetDefaultRoleDefinitionsRequest";

    @JsonCreator
    public static GetDefaultRoleDefinitionsRequest get() {
        return new GetDefaultRoleDefinitionsRequest();
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
