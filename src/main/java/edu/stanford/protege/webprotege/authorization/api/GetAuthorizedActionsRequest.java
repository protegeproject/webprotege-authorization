package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.ipc.Request;

public record GetAuthorizedActionsRequest(Resource resource, Subject subject) implements Request<GetAuthorizedActionsResponse> {

    public static final String CHANNEL_NAME = AuthorizationConstants.CHANNEL_NAME_PREFIX + "GetAuthorizedActions";

    @Override
    public String getChannel() {
        return CHANNEL_NAME;
    }
}
