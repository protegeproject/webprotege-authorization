package edu.stanford.protege.webprotege.authorization;

import edu.stanford.protege.webprotege.common.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
public record GetRolesRequest(Subject subject, Resource resource) implements Request<GetRolesResponse> {

    public static final String CHANNEL_NAME = "webprotege.authorization.GetRoles";

    @Override
    public String getChannel() {
        return CHANNEL_NAME;
    }
}
