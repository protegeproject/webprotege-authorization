package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.cmd.Response;
import edu.stanford.protege.webprotege.model.UserId;

import java.util.Set;

public record GetUserRolesResponse(UserId userId, Resource resource, Set<RoleId> roles) implements Response {

}
