package edu.stanford.protege.webprotege.authorization;

import edu.stanford.protege.webprotege.common.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-06
 */
public record GetAuthorizedSubjectsRequest(Resource resource, ActionId actionId) implements Request<GetAuthorizedSubjectsResponse> {

    public static final String CHANNEL_NAME = "webprotege.authorization.GetAuthorizedSubjects";

    @Override
    public String getChannel() {
        return CHANNEL_NAME;
    }
}
