package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Request;

@JsonTypeName("GetAuthorizedCapabilitiesRequest")
public record GetAuthorizedCapabilitiesRequest(Resource resource, Subject subject) implements Request<GetAuthorizedCapabilitiesResponse> {

    public static final String CHANNEL = "webprotege.authorization.GetAuthorizedCapabilities";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
