package edu.stanford.protege.webprotege.authorization.api;


import edu.stanford.protege.webprotege.common.Response;

import java.util.Set;

public record GetAuthorizedResourcesResponse(Subject subject, ActionId actionId, Set<Resource> resources) implements Response {

}
