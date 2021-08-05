package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.cmd.Request;
import edu.stanford.protege.webprotege.model.UserId;

import javax.annotation.Nonnull;

import static edu.stanford.protege.webprotege.authorization.api.AuthorizationConstants.CHANNEL_NAME_PREFIX;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 *
 * Get the roles assigned to a specific subject on a specific resource
 * @param subject The subject
 * @param resource The resource
 */
public record GetAssignedRolesRequest(@Nonnull Subject subject,
                                      @Nonnull Resource resource) implements Request<GetAssignedRolesResponse> {

    public static final String CHANNEL_NAME = CHANNEL_NAME_PREFIX + "GetAssignedRoles";

    @Override
    public String getChannel() {
        return CHANNEL_NAME;
    }
}
