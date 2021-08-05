package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.cmd.Request;
import edu.stanford.protege.webprotege.cmd.Response;
import edu.stanford.protege.webprotege.model.UserId;

import java.util.Set;

import static edu.stanford.protege.webprotege.authorization.api.AuthorizationConstants.CHANNEL_NAME_PREFIX;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
public record SetAssignedRolesRequest(UserId userId, Resource resource, Set<RoleId> roles) implements Request<Response> {

    public static final String CHANNEL_NAME = CHANNEL_NAME_PREFIX + "SetAssignedRoles";

    @Override
    public String getChannel() {
        return CHANNEL_NAME;
    }
}
