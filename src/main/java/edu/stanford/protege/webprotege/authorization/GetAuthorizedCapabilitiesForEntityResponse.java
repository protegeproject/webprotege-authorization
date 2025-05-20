package edu.stanford.protege.webprotege.authorization;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.Response;

import java.util.Set;

import static edu.stanford.protege.webprotege.authorization.GetAuthorizedCapabilitiesForEntityRequest.CHANNEL;

@JsonTypeName(CHANNEL)
public record GetAuthorizedCapabilitiesForEntityResponse(ImmutableSet<Capability> capabilities) implements Response {

}
