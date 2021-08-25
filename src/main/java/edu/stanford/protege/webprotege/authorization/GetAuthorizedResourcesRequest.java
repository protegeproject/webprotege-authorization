package edu.stanford.protege.webprotege.authorization;


import edu.stanford.protege.webprotege.common.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
public record GetAuthorizedResourcesRequest(Subject subject, ActionId actionId) implements Request<GetAuthorizedResourcesResponse> {

    public static final String CHANNEL_NAME = "webprotege.authorization.GetAuthorizedResources";

    @Override
    public String getChannel() {
        return CHANNEL_NAME;
    }
}
