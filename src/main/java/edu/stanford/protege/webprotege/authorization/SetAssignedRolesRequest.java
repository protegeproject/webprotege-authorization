package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Request;

import java.util.Set;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-05
 */
@JsonTypeName("SetAssignedRolesRequest")
public record SetAssignedRolesRequest(Subject subject, Resource resource, Set<RoleId> roles) implements Request<SetAssignedRolesResponse> {

    public static final String CHANNEL = "webprotege.authorization.SetAssignedRoles";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
