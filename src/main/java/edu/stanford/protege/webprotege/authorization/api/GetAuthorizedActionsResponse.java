package edu.stanford.protege.webprotege.authorization.api;

import edu.stanford.protege.webprotege.common.Response;

import java.util.Set;

public record GetAuthorizedActionsResponse(Resource resource, Subject subject, Set<ActionId> actionIds) implements Response {

}
