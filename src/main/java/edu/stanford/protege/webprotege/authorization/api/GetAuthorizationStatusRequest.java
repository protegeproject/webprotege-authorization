package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.ipc.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-06
 */
public record GetAuthorizationStatusRequest(Resource resource,
                                            Subject subject) implements Request<GetAuthorizationStatusResponse> {

    public static final String CHANNEL_NAME = AuthorizationConstants.CHANNEL_NAME_PREFIX + "GetAuthorizationStatus";

    @Override
    public String getChannel() {
        return CHANNEL_NAME;
    }
}
