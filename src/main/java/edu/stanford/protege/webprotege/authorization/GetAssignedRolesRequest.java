package edu.stanford.protege.webprotege.authorization;

import edu.stanford.protege.webprotege.common.Request;

import javax.annotation.Nonnull;


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

    public static final String CHANNEL = "webprotege.authorization.GetAssignedRoles";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
