package edu.stanford.protege.webprotege.authorization;


import edu.stanford.protege.webprotege.common.Response;

import java.util.Set;

public record GetRolesResponse(Subject subject, Resource resource, Set<RoleId> roles) implements Response {

}
