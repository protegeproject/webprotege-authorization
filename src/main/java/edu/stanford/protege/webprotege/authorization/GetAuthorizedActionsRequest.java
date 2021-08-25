package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Request;

@JsonTypeName("GetAuthorizedActionsRequest")
public record GetAuthorizedActionsRequest(Resource resource, Subject subject) implements Request<GetAuthorizedActionsResponse> {

    public static final String CHANNEL = "webprotege.authorization.GetAuthorizedActions";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
