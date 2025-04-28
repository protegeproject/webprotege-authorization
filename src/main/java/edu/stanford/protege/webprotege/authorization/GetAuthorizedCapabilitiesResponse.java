package edu.stanford.protege.webprotege.authorization;

import edu.stanford.protege.webprotege.common.Response;

import java.util.Set;

public record GetAuthorizedCapabilitiesResponse(Resource resource, Subject subject, Set<Capability> capabilities) implements Response {

}
