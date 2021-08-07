package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.cmd.Response;

import java.util.Set;

public record GetRolesResponse(Subject subject, Resource resource, Set<RoleId> roles) implements Response {

}