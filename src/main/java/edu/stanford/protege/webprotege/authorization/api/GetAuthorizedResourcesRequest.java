package edu.stanford.protege.webprotege.authorization.api;


import edu.stanford.protege.webprotege.ipc.Request;

import static edu.stanford.protege.webprotege.authorization.api.AuthorizationConstants.CHANNEL_NAME_PREFIX;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
public record GetAuthorizedResourcesRequest(Subject subject, ActionId actionId) implements Request<GetAuthorizedResourcesResponse> {

    public static final String CHANNEL_NAME = CHANNEL_NAME_PREFIX + "GetAuthorizedResources";

    @Override
    public String getChannel() {
        return CHANNEL_NAME;
    }
}
