package edu.stanford.protege.webprotege.authorization;


import edu.stanford.protege.webprotege.common.Response;

import java.util.Set;

public record GetAuthorizedResourcesResponse(Subject subject, Capability capability, Set<Resource> resources) implements Response {

}
