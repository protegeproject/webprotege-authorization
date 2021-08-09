package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.ipc.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-06
 */
public record GetAuthorizedSubjectsRequest(Resource resource, ActionId actionId) implements Request<GetAuthorizedSubjectsResponse> {

    public static final String CHANNEL_NAME = AuthorizationConstants.CHANNEL_NAME_PREFIX + "GetAuthorizedSubjects";

    @Override
    public String getChannel() {
        return CHANNEL_NAME;
    }
}
