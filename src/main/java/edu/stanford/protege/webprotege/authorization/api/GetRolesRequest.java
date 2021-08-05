package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.cmd.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
public record GetRolesRequest(Subject subject, Resource resource) implements Request<GetUserRolesResponse> {

    public static final String CHANNEL_NAME = "GetRoles";

    @Override
    public String getChannel() {
        return CHANNEL_NAME;
    }
}
